package com.ceostocks.model.social.entity;

import com.ceostocks.common.base.Base_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-03T00:40:13.372+0530")
@StaticMetamodel(Groups.class)
public class Groups_ extends Base_ {
	public static volatile SingularAttribute<Groups, BigDecimal> groupId;
	public static volatile SingularAttribute<Groups, String> groupName;
	public static volatile SingularAttribute<Groups, Boolean> isFavorites;
	public static volatile SingularAttribute<Groups, Integer> privicyType;
	public static volatile SingularAttribute<Groups, Integer> status;
}
