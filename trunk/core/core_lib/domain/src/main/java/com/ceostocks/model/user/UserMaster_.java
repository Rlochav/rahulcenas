package com.ceostocks.model.user;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.document.UserProfilePic;
import com.ceostocks.model.ecom.Company;
import com.ceostocks.model.social.page.UserPage;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-19T20:23:22.617+0530")
@StaticMetamodel(UserMaster.class)
public class UserMaster_ extends Base_ {
	public static volatile SingularAttribute<UserMaster, BigDecimal> userIndex;
	public static volatile SingularAttribute<UserMaster, String> userId;
	public static volatile SingularAttribute<UserMaster, String> firstName;
	public static volatile SingularAttribute<UserMaster, String> middleName;
	public static volatile SingularAttribute<UserMaster, String> lastName;
	public static volatile SingularAttribute<UserMaster, String> emailId;
	public static volatile SingularAttribute<UserMaster, String> password;
	public static volatile SingularAttribute<UserMaster, Integer> userType;
	public static volatile SingularAttribute<UserMaster, Integer> sex;
	public static volatile SingularAttribute<UserMaster, Date> dob;
	public static volatile SingularAttribute<UserMaster, Integer> country;
	public static volatile SingularAttribute<UserMaster, Boolean> isActive;
	public static volatile SingularAttribute<UserMaster, Integer> rowVersion;
	public static volatile SingularAttribute<UserMaster, String> activateCode;
	public static volatile SingularAttribute<UserMaster, String> timeLineId;
	public static volatile ListAttribute<UserMaster, UserRoles> userRoles;
	public static volatile ListAttribute<UserMaster, UserProfilePic> userProfilePics;
	public static volatile SetAttribute<UserMaster, UserPage> userPages;
	public static volatile SetAttribute<UserMaster, Company> companies;
	public static volatile SingularAttribute<UserMaster, UserSession> userSession;
	public static volatile ListAttribute<UserMaster, UserSessionLog> userSessionLogs;
}
