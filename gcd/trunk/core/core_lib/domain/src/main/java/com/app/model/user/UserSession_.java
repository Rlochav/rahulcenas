package com.app.model.user;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:19.901+0530")
@StaticMetamodel(UserSession.class)
public class UserSession_ {
	public static volatile SingularAttribute<UserSession, Long> sessionId;
	public static volatile SingularAttribute<UserSession, Integer> userIndex;
	public static volatile SingularAttribute<UserSession, Date> lastAccessDateTime;
	public static volatile SingularAttribute<UserSession, Date> lastLoginDateTime;
	public static volatile SingularAttribute<UserSession, String> ipAddress;
	public static volatile SingularAttribute<UserSession, Integer> rowVersion;
}
