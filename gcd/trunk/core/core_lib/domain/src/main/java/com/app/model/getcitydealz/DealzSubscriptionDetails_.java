package com.app.model.getcitydealz;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.362+0530")
@StaticMetamodel(DealzSubscriptionDetails.class)
public class DealzSubscriptionDetails_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<DealzSubscriptionDetails, Integer> subscriptionId;
	public static volatile SingularAttribute<DealzSubscriptionDetails, String> firstName;
	public static volatile SingularAttribute<DealzSubscriptionDetails, String> lastName;
	public static volatile SingularAttribute<DealzSubscriptionDetails, String> emailId;
	public static volatile SingularAttribute<DealzSubscriptionDetails, Integer> merchantId;
	public static volatile SingularAttribute<DealzSubscriptionDetails, Integer> isActive;
}
