package com.ceostocks.services.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.common.base.Base;
import com.ceostocks.common.dto.NotificationDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.social.post.UserFriends;
import com.ceostocks.model.social.post.UserFriendsFilter;
import com.ceostocks.model.social.post.UserFriendsRepository;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.services.user.UserServices;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private UserServices userServices;

	@Autowired
	private UserFriendsRepository userFriendsRepository;

	@Override
	public Map<String, List<NotificationDTO>> getFriendRequest(UserInfo userInfo) {
		Map<String, List<NotificationDTO>> map = new HashMap<String, List<NotificationDTO>>();
		List<NotificationDTO> notificationDTOs = new ArrayList<NotificationDTO>();
		UserFriendsFilter filter = new UserFriendsFilter();
		filter.setAccepterId(userInfo.getUserIndex());
		filter.setIsRequestAccepted(false);
		filter.setIsSeen(false);
		List<UserFriends> userFriends = userFriendsRepository.searchByCriteria(filter, -1, -1);
		userFriends.forEach(userfrnd -> {
			UserMaster requesterUserDetails = userServices.getUserMasterByIndex(userfrnd.getUserFriendsPK().getRequesterId());

			NotificationDTO dto = new NotificationDTO(requesterUserDetails.getTimeLineId(), requesterUserDetails.getFirstName() + " "
					+ requesterUserDetails.getLastName(), requesterUserDetails.getEmailId(), null);

			requesterUserDetails.getUserProfilePics().parallelStream().filter(p -> !p.getStatus().equals(Base.IN_ACTIVE)).forEach(pic -> {
				dto.setProfilePic(pic.getSavedAs());
			});

			notificationDTOs.add(dto);
		});
		map.put("friendRequests", notificationDTOs);
		return map;
	}
}
