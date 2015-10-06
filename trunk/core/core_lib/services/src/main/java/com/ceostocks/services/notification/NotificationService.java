package com.ceostocks.services.notification;

import java.util.List;
import java.util.Map;

import com.ceostocks.common.dto.NotificationDTO;
import com.ceostocks.common.dto.UserInfo;

public interface NotificationService {

	Map<String, List<NotificationDTO>> getFriendRequest(UserInfo userInfo);

}
