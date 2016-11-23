package com.app.model.subscriber;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.902+0530")
@StaticMetamodel(Subscribers.class)
public class Subscribers_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<Subscribers, Integer> subscriberId;
	public static volatile SingularAttribute<Subscribers, String> firstName;
	public static volatile SingularAttribute<Subscribers, String> lastName;
	public static volatile SingularAttribute<Subscribers, String> emailId;
	public static volatile SingularAttribute<Subscribers, Integer> subscriptionType;
	public static volatile SingularAttribute<Subscribers, Integer> isActive;
	public static volatile ListAttribute<Subscribers, SubscriberNeighborhoodsLink> neighborhoodsLinks;
	public static volatile ListAttribute<Subscribers, SubscriberCategoryLink> subscriberCategoryLinks;
}
