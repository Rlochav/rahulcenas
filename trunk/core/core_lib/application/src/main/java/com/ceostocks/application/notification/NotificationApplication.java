package com.ceostocks.application.notification;

import java.util.List;
import java.util.Map;

import com.ceostocks.common.dto.NotificationDTO;
import com.ceostocks.common.dto.UserInfo;

public interface NotificationApplication {

	Map<String, List<NotificationDTO>> getNotification(UserInfo userInfo);

}
