package com.app.model.user;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:19.929+0530")
@StaticMetamodel(UserSessionLog.class)
public class UserSessionLog_ {
	public static volatile SingularAttribute<UserSessionLog, Integer> logId;
	public static volatile SingularAttribute<UserSessionLog, Long> sessionId;
	public static volatile SingularAttribute<UserSessionLog, Integer> userIndex;
	public static volatile SingularAttribute<UserSessionLog, Date> loginDateTime;
	public static volatile SingularAttribute<UserSessionLog, Date> lastAccessDateTime;
	public static volatile SingularAttribute<UserSessionLog, Date> lastAttamptDateTime;
	public static volatile SingularAttribute<UserSessionLog, String> ipAddress;
	public static volatile SingularAttribute<UserSessionLog, Integer> presentConcurrency;
	public static volatile SingularAttribute<UserSessionLog, Integer> rowVersion;
}
