package com.ceostocks.model.document;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.user.UserMaster;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-12T14:26:29.037+0530")
@StaticMetamodel(UserProfilePic.class)
public class UserProfilePic_ extends Base_ {
	public static volatile SingularAttribute<UserProfilePic, BigDecimal> id;
	public static volatile SingularAttribute<UserProfilePic, String> contentType;
	public static volatile SingularAttribute<UserProfilePic, String> originalFileName;
	public static volatile SingularAttribute<UserProfilePic, String> savedAs;
	public static volatile SingularAttribute<UserProfilePic, Integer> status;
	public static volatile SingularAttribute<UserProfilePic, UserMaster> userMaster;
}
