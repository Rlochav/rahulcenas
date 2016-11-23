package com.app.model.user;

import com.app.model.base.BaseNoUDF_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.914+0530")
@StaticMetamodel(UserMaster.class)
public class UserMaster_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<UserMaster, Integer> userIndex;
	public static volatile SingularAttribute<UserMaster, String> emailId;
	public static volatile SingularAttribute<UserMaster, String> userId;
	public static volatile SingularAttribute<UserMaster, String> firstName;
	public static volatile SingularAttribute<UserMaster, String> middleName;
	public static volatile SingularAttribute<UserMaster, String> lastName;
	public static volatile SingularAttribute<UserMaster, String> password;
	public static volatile SingularAttribute<UserMaster, Integer> status;
	public static volatile SingularAttribute<UserMaster, Integer> userType;
	public static volatile SingularAttribute<UserMaster, Date> lastVisitDateTime;
	public static volatile SingularAttribute<UserMaster, Integer> failedAttamptCount;
	public static volatile SingularAttribute<UserMaster, Date> lastAttamptDateTime;
	public static volatile SingularAttribute<UserMaster, String> phone;
	public static volatile SingularAttribute<UserMaster, String> fax;
	public static volatile SingularAttribute<UserMaster, Date> userActiveTillDate;
	public static volatile SingularAttribute<UserMaster, Date> dateOfBirth;
	public static volatile SingularAttribute<UserMaster, Integer> dobVerifyReq;
	public static volatile SingularAttribute<UserMaster, String> errorMessage;
}
