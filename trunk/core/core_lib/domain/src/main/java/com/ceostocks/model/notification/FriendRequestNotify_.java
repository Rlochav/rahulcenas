package com.ceostocks.model.notification;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-26T00:45:33.390+0530")
@StaticMetamodel(FriendRequestNotify.class)
public class FriendRequestNotify_ extends Notification_ {
	public static volatile SingularAttribute<FriendRequestNotify, BigDecimal> requesterId;
	public static volatile SingularAttribute<FriendRequestNotify, BigDecimal> accepterId;
	public static volatile SingularAttribute<FriendRequestNotify, Boolean> isRequestAccepted;
}
