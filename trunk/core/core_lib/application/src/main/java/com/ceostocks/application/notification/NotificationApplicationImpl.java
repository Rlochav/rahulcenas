package com.ceostocks.application.notification;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.dto.NotificationDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.services.notification.NotificationService;
import com.ceostocks.services.user.UserServices;

public class NotificationApplicationImpl implements NotificationApplication {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserServices userServices;

	@CeoStocksReadOnlyTxn
	@Override
	public Map<String, List<NotificationDTO>> getNotification(UserInfo userInfo) {
		Map<String, List<NotificationDTO>> friendRequests = notificationService.getFriendRequest(userInfo);
		return friendRequests;
	}
}
