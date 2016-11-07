package com.ceostocks.mvc.urls;

/**
 * Constants for pages URL
 * 
 * @author Arun
 *
 */
public class CeoUrls {

	/**
	 * ROOT URL.
	 */
	public static final String CEO_ROOT = "";
	/**
	 * Landing page URL.
	 */
	public static final String CEO_INDEX = "/index";
	/**
	 * User Home Page URL.
	 */
	public static final String CEO_HOME = "/home";
	/**
	 * Site Admin Page URL.
	 */
	public static final String CEO_SITE_ADMIN = "/siteAdmin";
	public static final String CEO_GET_ONLINE_USER_LIST = "/getOnlineUserList";
	public static final String CEO_SEND_USER_CHAT = "/sendUserChat";
	public static final String CEO_GET_USER_CHAT = "/getUserChat";
	public static final String CEO_OPEN_PRODUCT_MANAGEMENT = "/openProductManagement";
	public static final String CEO_OPEN_CREATE_PRODUCT = "/openCreateProduct";
	public static final String CEO_SAVE_PRODUCT = "/saveProduct";
	public static final String CEO_DELETE_PRODUCT = "/deleteProduct";

	/**
	 * Category Management
	 */
	public static final String CEO_OPEN_CATEGORY_MASTER = "/openCategoryMaster";
	public static final String CEO_SAVE_CATEGORY = "/saveCategory";
	public static final String CEO_DELETE_CATEGORY = "/deleteCategory";
	public static final String CEO_SEARCH_CATEGORY = "/searchCategory";

	/**
	 * Sub-Category Management
	 */
	public static final String CEO_OPEN_SUB_CATEGORY_MASTER = "/openSubCategoryMaster";
	public static final String CEO_SAVE_SUB_CATEGORY = "/saveSubCategory";
	public static final String CEO_DELETE_SUB_CATEGORY = "/deleteSubCategory";
	public static final String CEO_SEARCH_SUB_CATEGORY = "/searchSubCategory";

	/**
	 * Social
	 */
	public static final String CEO_USER_PROFILE = "{timelineId}";
	public static final String CEO_SEARCH_FRIEND = "searchFriend";
	public static final String CEO_JSON_SEARCH_FRIEND = "jsonSearchFriend";
	public static final String CEO_JSON_SEND_FRIEND_REQUEST = "jsonSendFriendRequest";
	public static final String CEO_JSON_CONFIRM_FRIEND_REQUEST = "jsonConfirmFriendRequest";
	public static final String CEO_JSON_GET_USER_FRIENDS = "jsonGetUserFriends";
	public static final String CEO_SAVE_STATUS = "/saveStatus";
	public static final String CEO_GET_TIMELINE_STATUS = "/getTimelineStatus";
	public static final String CEO_SAVE_POST_COMMENT = "savePostComment";

	/**
	 * Groups
	 */
	public static final String CEO_SAVE_GROUP = "saveGroup";
	public static final String CEO_DELETE_GROUP = "deleteGroup";
	public static final String CEO_JOIN_GROUP = "joinGroup";
	public static final String CEO_LEAVE_GROUP = "leaveGroup";
	public static final String CEO_GET_ALL_JOINED_GROUP = "getAllJoinedGroup";

	/**
	 * Notification
	 */
	public static final String CEO_JSON_GET_NOTIFICATION = "jsonGetNotification";

	/**
	 * CMS
	 */
	public static final String CEO_CMS_CONTENT_LIST = "cmsContentList";
	public static final String CEO_CMS_PAGE_LIST = "cmsPageList";
	public static final String CEO_CMS_PAGE_CONTENT_EDITOR = "cmsPageContentEditor";
	public static final String CEO_CMS_URL_LIST = "cmsUrlList";
	public static final String CEO_CMS_URL_MASTER = "cmsUrlMaster";
	public static final String CEO_CMS_MENU_LIST = "cmsMenuList";
	public static final String CEO_CMS_MENU_MASTER = "cmsMenuMaster";
	public static final String CEO_CMS_URL_CATEGORY_MASTER = "cmsUrlCategoryMaster";
	public static final String CEO_CMS_GET_CMS_URLS = "getCmsUrl";
	public static final String CEO_CMS_GET_CMS_URLS_CATEGORY = "getCmsUrlsCategory";
	public static final String CEO_CMS_SAVE_CMS_URL_CATEGORY = "saveCmsUrlCategory";
	
}
