package com.app.model.levelmaster;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.799+0530")
@StaticMetamodel(LevelMaster.class)
public class LevelMaster_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<LevelMaster, Integer> levelId;
	public static volatile SingularAttribute<LevelMaster, String> levelType;
	public static volatile SingularAttribute<LevelMaster, String> levelFullYearPrice;
	public static volatile SingularAttribute<LevelMaster, String> quarterPaymentPrice;
}
