package com.ceostocks.mvc.social;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceostocks.application.notification.NotificationApplication;
import com.ceostocks.common.dto.NotificationDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@RestController
@RequestMapping("/component/notify")
public class NotificationController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4266031177406911134L;

	@Autowired
	private NotificationApplication notificationApplication;

	@RequestMapping(value = CeoUrls.CEO_JSON_GET_NOTIFICATION, method = RequestMethod.POST)
	public Map<String, List<NotificationDTO>> getNotification() {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			Map<String, List<NotificationDTO>> notifyMap = notificationApplication.getNotification(userInfo);
			return notifyMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
