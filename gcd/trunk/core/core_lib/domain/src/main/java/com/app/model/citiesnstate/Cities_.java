package com.app.model.citiesnstate;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-15T11:12:58.078+0530")
@StaticMetamodel(Cities.class)
public class Cities_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<Cities, Integer> cityId;
	public static volatile SingularAttribute<Cities, String> cityCode;
	public static volatile SingularAttribute<Cities, String> cityName;
	public static volatile SingularAttribute<Cities, String> timeZoneId;
}
