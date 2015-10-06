package com.ceostocks.application.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ceostocks.common.base.Base;
import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.common.dto.PostDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.enums.Privacy;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.model.document.Document;
import com.ceostocks.model.social.post.TimelinePost;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.services.user.UserServices;

public class PostDTOMapper {

	public static TimelinePost mapper(PostDTO postDTO) {
		return new TimelinePost(postDTO.getPostText(), IntUtil.getInteger(postDTO.getVisibility()), IntUtil.getInteger(postDTO.getStatus()),
				postDTO.getTimelineId());
	}

	public static PostDTO mapper(TimelinePost timelinePost, UserServices userServices) {
		List<String> imageList = new ArrayList<>();
		for (Document document : timelinePost.getDocuments()) {
			imageList.add(document.getFileSavedAs().replace(".", "|"));
		}
		UserMaster userMaster = userServices.getUserMasterByIndex(timelinePost.getCreatedBy());
		UserInfo userInfo = userServices.getUserDetailsByTimelineId(timelinePost.getTimeLineId());
		return new PostDTO(timelinePost.getPostId().toString(), timelinePost.getPost(), imageList.toArray(new String[imageList.size()]),
				userMaster.getFirstName() + " " + userMaster.getLastName(), DateUtil.parseDateToString(timelinePost.getCreatedDate(), DateUtil.dateTimeFormat),
				DateUtil.parseDateToString(timelinePost.getUpdatedDate(), DateUtil.dateTimeFormat), timelinePost.getVisibility().toString(), timelinePost
						.getStatus().toString(), userMaster.getTimeLineId(), !userMaster.getUserIndex().equals(userInfo.getUserIndex()) + "");
	}

	public static List<PostDTO> mapper(List<TimelinePost> timelinePosts, UserServices userServices) {
		List<PostDTO> list = new ArrayList<PostDTO>();
		if (timelinePosts != null) {
			timelinePosts.forEach(timelinePost -> {
				List<String> imageList = new ArrayList<>();
				for (Document document : timelinePost.getDocuments()) {
					imageList.add(document.getFileSavedAs().replace(".", "|"));
				}
				UserMaster userMaster = userServices.getUserMasterByIndex(timelinePost.getCreatedBy());
				UserInfo userInfo = userServices.getUserDetailsByTimelineId(timelinePost.getTimeLineId());
				PostDTO dto = new PostDTO(timelinePost.getPostId().toString(), timelinePost.getPost(), imageList.toArray(new String[imageList.size()]),
						userMaster.getFirstName() + " " + userMaster.getLastName(), DateUtil.parseDateToString(timelinePost.getCreatedDate(),
								DateUtil.dateTimeFormat), DateUtil.parseDateToString(timelinePost.getUpdatedDate(), DateUtil.dateTimeFormat), Privacy
								.getNameByCode(timelinePost.getVisibility()), timelinePost.getStatus().toString(), userMaster.getTimeLineId(), !userMaster
								.getUserIndex().equals(userInfo.getUserIndex()) + "");

				userMaster.getUserProfilePics().parallelStream().filter(p -> !p.getStatus().equals(Base.IN_ACTIVE)).forEach(pic -> {
					dto.setPostedByUserPic(pic.getSavedAs());
				});

				timelinePost.getComments().forEach(cmnt -> {
					CommentDTO cmntDto = new CommentDTO(cmnt.getCommentId().toString(), cmnt.getCommentText());
					UserMaster uMaster = userServices.getUserMasterByIndex(cmnt.getCreatedBy());
					cmntDto.setCreatedByText(uMaster.getFirstName() + " " + uMaster.getLastName());

					uMaster.getUserProfilePics().parallelStream().filter(p -> !p.getStatus().equals(Base.IN_ACTIVE)).forEach(pic -> {
						cmntDto.setCommentedByUserPic(pic.getSavedAs());
					});

					dto.addCommentDTO(cmntDto);
				});
				list.add(dto);
			});
		}
		return list;
	}
}
