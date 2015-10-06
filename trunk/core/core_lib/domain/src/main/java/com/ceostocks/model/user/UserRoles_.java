package com.ceostocks.model.user;

import com.ceostocks.common.base.Base_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-31T23:50:12.963+0530")
@StaticMetamodel(UserRoles.class)
public class UserRoles_ extends Base_ {
	public static volatile SingularAttribute<UserRoles, UserRolesPK> userRolesPK;
	public static volatile SingularAttribute<UserRoles, Boolean> isActive;
	public static volatile SingularAttribute<UserRoles, UserMaster> userMaster;
	public static volatile SingularAttribute<UserRoles, RoleMaster> roleMaster;
}
