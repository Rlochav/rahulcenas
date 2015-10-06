package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-12T14:30:59.202+0530")
@StaticMetamodel(UserSession.class)
public class UserSession_ {
	public static volatile SingularAttribute<UserSession, Integer> sessionId;
	public static volatile SingularAttribute<UserSession, Date> lastAccessDateTime;
	public static volatile SingularAttribute<UserSession, Date> lastLoginDateTime;
	public static volatile SingularAttribute<UserSession, String> ipAddress;
	public static volatile SingularAttribute<UserSession, Integer> rowVersion;
	public static volatile SingularAttribute<UserSession, BigDecimal> userIndex;
}
