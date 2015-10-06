package com.ceostocks.model.notification;

import com.ceostocks.common.base.Base_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-20T19:45:39.239+0530")
@StaticMetamodel(Notification.class)
public class Notification_ extends Base_ {
	public static volatile SingularAttribute<Notification, BigDecimal> notificationId;
	public static volatile SingularAttribute<Notification, Boolean> isSeen;
}
