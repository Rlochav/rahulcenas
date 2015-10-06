package com.ceostocks.model.user;

import com.ceostocks.common.base.Base_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-12T14:28:13.012+0530")
@StaticMetamodel(RightMaster.class)
public class RightMaster_ extends Base_ {
	public static volatile SingularAttribute<RightMaster, BigDecimal> rightId;
	public static volatile SingularAttribute<RightMaster, String> description;
	public static volatile SingularAttribute<RightMaster, String> processId;
	public static volatile SingularAttribute<RightMaster, String> functionCode;
	public static volatile SingularAttribute<RightMaster, String> functionDescr;
	public static volatile SingularAttribute<RightMaster, Boolean> isActive;
	public static volatile ListAttribute<RightMaster, RoleRightLink> roleRightLinks;
}
