package com.ceostocks.application.mapper;

import com.ceostocks.common.dto.FriendRequestDTO;
import com.ceostocks.model.social.post.UserFriends;

public class FriendRequestDTOMapper {

	public static FriendRequestDTO mapper(UserFriends userFriends) {
		FriendRequestDTO dto = new FriendRequestDTO(userFriends.getUserFriendsPK().getRequesterId().toString(), userFriends.getUserFriendsPK().getAccepterId()
				.toString(), userFriends.getIsRequestAccepted().toString());
		return dto;
	}

}
