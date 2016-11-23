package com.app.model.user;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:19.887+0530")
@StaticMetamodel(UserPreference.class)
public class UserPreference_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<UserPreference, Integer> userIndex;
	public static volatile SingularAttribute<UserPreference, Integer> type;
	public static volatile SingularAttribute<UserPreference, Integer> keyPreference;
	public static volatile SingularAttribute<UserPreference, String> value;
}
