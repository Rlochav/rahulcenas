package com.app.model.levelmaster;

import com.app.model.base.BaseNoUDF_;
import com.app.model.getcitydealz.SubLevelMasterPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:19.496+0530")
@StaticMetamodel(SubLevelMaster.class)
public class SubLevelMaster_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<SubLevelMaster, SubLevelMasterPK> subLevelMasterPK;
	public static volatile SingularAttribute<SubLevelMaster, String> subLevelType;
	public static volatile SingularAttribute<SubLevelMaster, String> isActive;
}
