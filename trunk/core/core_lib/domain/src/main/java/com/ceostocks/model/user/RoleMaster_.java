package com.ceostocks.model.user;

import com.ceostocks.common.base.Base_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-12T14:28:35.166+0530")
@StaticMetamodel(RoleMaster.class)
public class RoleMaster_ extends Base_ {
	public static volatile SingularAttribute<RoleMaster, BigDecimal> roleId;
	public static volatile SingularAttribute<RoleMaster, String> roleName;
	public static volatile SingularAttribute<RoleMaster, String> isActive;
	public static volatile ListAttribute<RoleMaster, RoleRightLink> roleRightLinks;
	public static volatile ListAttribute<RoleMaster, UserRoles> userRoles;
}
