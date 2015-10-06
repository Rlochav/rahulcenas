package com.ceostocks.services.user;

import static com.ceostocks.services.jms.MessageConstant.EMAIL_ID;
import static com.ceostocks.services.jms.MessageConstant.FIRST_NAME;
import static com.ceostocks.services.jms.MessageConstant.SUBJECT;
import static com.ceostocks.services.jms.MessageConstant.URL;
import static java.lang.String.format;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.dto.FriendDTO;
import com.ceostocks.common.dto.FriendRequestDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.exception.CeoStocksAppException;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.model.document.UserProfilePic;
import com.ceostocks.model.notification.FriendRequestNotifyRepository;
import com.ceostocks.model.social.post.UserFriends;
import com.ceostocks.model.social.post.UserFriendsPK;
import com.ceostocks.model.social.post.UserFriendsRepository;
import com.ceostocks.model.user.RoleRightLink;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.model.user.UserMasterFilter;
import com.ceostocks.model.user.UserMasterRepository;
import com.ceostocks.model.user.UserRoles;
import com.ceostocks.model.user.UserSession;
import com.ceostocks.model.user.UserSessionLog;
import com.ceostocks.model.user.UserSessionLogRepository;
import com.ceostocks.model.user.UserSessionRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private UserSessionRepository userSessionRepository;
	@Autowired
	private UserSessionLogRepository userSessionLogRepository;

	@Autowired
	private UserFriendsRepository userFriendsRepository;

	@Autowired
	private FriendRequestNotifyRepository friendRequestNotifyRepository;

	// @Autowired
	// private EmailProducer emailProducer;

	@Override
	public UserMaster doLogin(String userId, String password, String ipAddress) {
		UserMaster userMaster = userMasterRepository.getByEmailOrUserId(userId);
		if (userMaster != null) {
			if (!userMaster.getPassword().equals(password))
				throw new CeoStocksAppException("UserId or password doesn't exist.");
			if (!userMaster.getIsActive().equals(true))
				throw new CeoStocksAppException("User not activated.");

			// UserSession
			UserSession userSession = new UserSession();
			userSession.create(ipAddress, userMaster.getUserIndex());
			UserSession uSession = userSessionRepository.getUserSessionByUserIndex(userMaster.getUserIndex());
			if (uSession != null)
				userSessionRepository.delete(uSession);
			userSessionRepository.save(userSession);

			UserSessionLog userSessionLog = new UserSessionLog();
			userSessionLog.create(userSession.getSessionId(), userMaster.getUserIndex(), ipAddress);
			userSessionLogRepository.save(userSessionLog);
		} else {
			throw new CeoStocksAppException("UserId or password doesn't exist.");
		}
		return userMaster;
	}

	@Override
	public UserMaster doRegisterUser(UserMaster userMaster) {
		if (userMaster.getUserIndex() == null) {
			validateEmailId(userMaster.getEmailId());
			userMaster.setCreatedBy(new BigDecimal("0"));
			userMaster.setCreatedDate(new Date());
		}

		// Send Activation e-mail
		if (!userMaster.getIsActive()) {
			Map<String, String> emailContentMap = new HashMap<String, String>();
			emailContentMap.put(EMAIL_ID.name(), userMaster.getEmailId());
			emailContentMap.put(SUBJECT.name(), userMaster.getEmailId());
			emailContentMap.put(FIRST_NAME.name(), userMaster.getFirstName());
			emailContentMap.put(URL.name(), userMaster.getFirstName());
			// emailProducer.notify(emailContentMap);
		}

		userMaster.setUpdatedDate(new Date());
		userMaster.setUpdatedBy(new BigDecimal("0"));
		userMasterRepository.update(userMaster);
		return userMaster;
	}

	private void validateEmailId(String emailId) {
		if (userMasterRepository.isEmailUnique(emailId))
			throw new CeoStocksAppException(format("e-mail id %s already exist.", emailId));
	}

	@Override
	public UserMaster getUserMasterByEmailId(String emailId) {
		return userMasterRepository.getByEmailOrUserId(emailId);
	}

	@Override
	public UserMaster getUserMasterByActivationCode(String activationCode) {
		UserMasterFilter filter = new UserMasterFilter();
		filter.setActivateCode(activationCode);
		List<UserMaster> userMasters = userMasterRepository.searchByCriteria(filter, -1, -1);
		return userMasters.size() > 0 ? userMasters.get(0) : null;
	}

	@Override
	public UserMaster saveUserProfilePic(UserMaster userMaster, DocumentDTO documentDTO) {
		List<UserProfilePic> userProfilePics = userMaster.getUserProfilePics();
		for (UserProfilePic pic : userProfilePics) {
			if (pic.getStatus() != 666) {
				pic.setUpdatedBy(userMaster.getUpdatedBy());
				pic.setUpdatedDate(new Date());
				pic.setStatus(666);
			}
		}
		UserProfilePic userProfilePic = new UserProfilePic();
		userProfilePic.setOriginalFileName(documentDTO.getOrignalFileName());
		userProfilePic.setSavedAs(documentDTO.getFileSavedAs());
		userProfilePic.setStatus(1);
		userProfilePic.setContentType(documentDTO.getContentType());
		userProfilePic.setUserMaster(userMaster);
		userProfilePic.setCreatedBy(userMaster.getUserIndex());
		userProfilePic.setCreatedDate(new Date());
		userProfilePic.setUpdatedBy(userMaster.getUpdatedBy());
		userProfilePic.setUpdatedDate(new Date());
		userMaster.addUserProfilePics(userProfilePic);
		userMasterRepository.update(userMaster);
		return userMaster;
	}

	@Override
	public UserMaster getUserMasterByIndex(BigDecimal userIndex) {
		return userMasterRepository.findById(userIndex);
	}

	@Override
	public List<UserMaster> searchFriends(FriendDTO friendDTO, UserInfo userInfo) {
		UserMasterFilter filter = new UserMasterFilter();
		filter.setFirstName("%" + friendDTO.getFirstName().toLowerCase() + "%");
		filter.setLastName("%" + friendDTO.getFirstName().toLowerCase() + "%");
		filter.setEmailId(friendDTO.getFirstName());
		filter.setOfFlag(true);
		List<UserMaster> userMasters = userMasterRepository.searchByCriteria(filter, -1, -1);
		return userMasters;
	}

	@Override
	public UserFriends sendFriendRequest(FriendRequestDTO friendRequestDTO) {
		UserMaster accepter = getUserMasterByEmailId(friendRequestDTO.getFriendRequestTo());
		if (accepter == null)
			throw new IllegalArgumentException("Friend doesn't exist.");

		UserMaster requester = getUserMasterByIndex(new BigDecimal(friendRequestDTO.getFriendRequestFrom()));
		UserFriends userFriends = new UserFriends(new UserFriendsPK(requester.getUserIndex(), accepter.getUserIndex()), false);
		userFriendsRepository.save(userFriends);
		return userFriends;
	}

	@Override
	public UserFriends getUserFriend(BigDecimal requestUserIndex, BigDecimal friendUserIndex) {
		UserMaster friend = getUserMasterByIndex(friendUserIndex);
		if (friend == null)
			throw new IllegalArgumentException("Friend doesn't exist.");

		UserMaster user = getUserMasterByIndex(requestUserIndex);
		return userFriendsRepository.findById(new UserFriendsPK(user.getUserIndex(), friend.getUserIndex()));
	}

	@Override
	public UserFriends confirmFriendRequest(FriendRequestDTO friendRequestDTO, UserInfo userInfo) {
		UserMaster requester = getUserMasterByEmailId(friendRequestDTO.getFriendRequestTo());
		if (requester == null)
			throw new IllegalArgumentException("Friend doesn't exist.");
		UserFriends userFriends = getUserFriend(requester.getUserIndex(), userInfo.getUserIndex());
		userFriends.setIsRequestAccepted(true);
		userFriendsRepository.update(userFriends);
		return userFriends;
	}

	@Override
	public List<UserFriends> getUserFriends(UserInfo userInfo, FriendDTO friendDTO) {
		UserMaster userMaster = userMasterRepository.findById(userInfo.getUserIndex());
		List<UserFriends> userFriends = userFriendsRepository.getUserFriends(userMaster.getUserIndex(), 0, 10);
		return userFriends;
	}

	@Override
	public UserInfo getUserDetailsByTimelineId(String timelineId) {
		UserMasterFilter filter = new UserMasterFilter();
		filter.setTimeLineId(timelineId);
		List<UserMaster> userMasters = userMasterRepository.searchByCriteria(filter, -1, -1);
		if (userMasters.size() == 0)
			throw new IllegalArgumentException("Invalid timlineId.");
		return convertToUserInfo(userMasters.get(0));
	}

	private UserInfo convertToUserInfo(UserMaster userMaster) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserIndex(userMaster.getUserIndex());
		userInfo.setFirstName(userMaster.getFirstName());
		userInfo.setLastName(userMaster.getLastName());
		userInfo.setEmailId(userMaster.getEmailId());
		userInfo.setDob(DateUtil.parseDateToString(userMaster.getDob(), DateUtil.dateFormat));
		userInfo.setCountry(userMaster.getCountry().toString());
		userInfo.setTimelineId(userMaster.getTimeLineId());
		userInfo.setUserSessionId(userMaster.getUserSession() != null ? userMaster.getUserSession().getSessionId().toString() : null);
		for (UserRoles userRoles : userMaster.getUserRoles()) {
			List<RoleRightLink> roleRightLinks = userRoles.getRoleMaster().getRoleRightLinks();
			for (RoleRightLink roleRightLink : roleRightLinks) {
				userInfo.putPermissionMap(roleRightLink.getRightMaster().getProcessId() + "_" + roleRightLink.getRightMaster().getFunctionCode(), "true");
			}
		}
		for (UserProfilePic pic : userMaster.getUserProfilePics()) {
			if (pic.getStatus() != 666)
				userInfo.setProfilePic(pic.getSavedAs());
		}
		return userInfo;
	}
}
