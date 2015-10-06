package com.ceostocks.model.social.page;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.user.UserMaster;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-12T10:36:56.398+0530")
@StaticMetamodel(UserPage.class)
public class UserPage_ extends Base_ {
	public static volatile SingularAttribute<UserPage, BigDecimal> id;
	public static volatile SingularAttribute<UserPage, String> title;
	public static volatile SingularAttribute<UserPage, UserMaster> userMaster;
}
