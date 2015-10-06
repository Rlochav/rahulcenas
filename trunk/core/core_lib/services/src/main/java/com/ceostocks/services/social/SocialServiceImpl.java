package com.ceostocks.services.social;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ceostocks.common.ResourceNotFoundException;
import com.ceostocks.common.dto.GroupDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.enums.Privacy;
import com.ceostocks.model.social.entity.Groups;
import com.ceostocks.model.social.entity.GroupsRepository;
import com.ceostocks.model.social.entity.GroupsUserLink;
import com.ceostocks.model.social.entity.GroupsUserLinkPK;
import com.ceostocks.model.social.entity.GroupsUserLinkRepository;

/**
 * 
 * @author Arun
 *
 */
@Service
public class SocialServiceImpl implements SocialService {

	@Autowired
	private GroupsRepository groupsRepository;
	@Autowired
	private GroupsUserLinkRepository groupsUserLinkRepository;

	/**
	 * Create/Update/Delete Groups.
	 */
	@Override
	public GroupDTO manageGroup(UserInfo userInfo, GroupDTO groupDTO) {
		Groups groups = null;
		if (groupDTO.getGroupId() == null) {
			groups = new Groups();
			groups.setCreatedBy(userInfo.getUserIndex());
		} else {
			groups = groupsRepository.findById(groupDTO.getGroupId());
			if (groups == null)
				throw new ResourceNotFoundException("group not found for given id=" + groupDTO.getGroupId());
		}

		groups.modify(groupDTO.getGroupName(), groupDTO.getIsFavorites(), Privacy.getCodeByName(groupDTO.getPrivicyType()), groupDTO.getStatus());
		groups.setUpdatedBy(userInfo.getUserIndex());
		groupsRepository.save(groups);
		groupDTO.setGroupId(groups.getGroupId());
		return groupDTO;
	}

	@Override
	public GroupDTO joinGroup(UserInfo userInfo, GroupDTO groupDTO) {
		Groups groups = groupsRepository.findById(groupDTO.getGroupId());
		if (groups == null)
			throw new ResourceNotFoundException("group not found for given id=" + groupDTO.getGroupId());

		GroupsUserLink groupsUserLink = new GroupsUserLink(new GroupsUserLinkPK(groups.getGroupId(), userInfo.getUserIndex()), new Date());
		groupsUserLinkRepository.save(groupsUserLink);
		return groupDTO;
	}

	@Override
	public GroupDTO leaveGroup(UserInfo userInfo, GroupDTO groupDTO) {
		Groups groups = groupsRepository.findById(groupDTO.getGroupId());
		if (groups == null)
			throw new ResourceNotFoundException("group not found for given id=" + groupDTO.getGroupId());
		GroupsUserLink groupsUserLink = groupsUserLinkRepository.findById(new GroupsUserLinkPK(groups.getGroupId(), userInfo.getUserIndex()));
		if (groupsUserLink == null)
			throw new ResourceNotFoundException("User not connected any more from group.");
		groupsUserLinkRepository.delete(groupsUserLink);
		return groupDTO;
	}

	@Override
	public List<GroupDTO> getAllJoindGroups(UserInfo userInfo) {
		List<GroupsUserLink> groupsUserLinks = groupsUserLinkRepository.getAllJoindGroups(userInfo.getUserIndex());
		List<GroupDTO> groupDTOs = new ArrayList<>();
		if (!CollectionUtils.isEmpty(groupsUserLinks)) {
			groupsUserLinks.forEach(link -> {
				Groups groups = groupsRepository.findById(link.getGroupsUserLinkPK().getGroupId());
				GroupDTO dto = new GroupDTO(groups.getGroupId(), groups.getGroupName(), groups.getIsFavorites(),
						Privacy.getNameByCode(groups.getPrivicyType()), null);
				groupDTOs.add(dto);
			});
		}
		return groupDTOs;
	}

	@Override
	public GroupDTO getGroupDetailsById(UserInfo userInfo, GroupDTO groupDTO) {
		Groups groups = groupsRepository.findById(groupDTO.getGroupId());
		if (groups == null)
			throw new ResourceNotFoundException("group not found for given id=" + groupDTO.getGroupId());
		GroupDTO dto = new GroupDTO(groups.getGroupId(), groups.getGroupName(), groups.getIsFavorites(), Privacy.getNameByCode(groups.getPrivicyType()), null);
		return dto;
	}
}
