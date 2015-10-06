package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-12T14:31:59.859+0530")
@StaticMetamodel(UserSessionLog.class)
public class UserSessionLog_ {
	public static volatile SingularAttribute<UserSessionLog, Integer> logId;
	public static volatile SingularAttribute<UserSessionLog, Integer> userSessionId;
	public static volatile SingularAttribute<UserSessionLog, BigDecimal> userIndex;
	public static volatile SingularAttribute<UserSessionLog, Date> lastAccessDateTime;
	public static volatile SingularAttribute<UserSessionLog, Date> lastAttamptDateTime;
	public static volatile SingularAttribute<UserSessionLog, String> ipAddress;
	public static volatile SingularAttribute<UserSessionLog, Integer> rowVersion;
}
