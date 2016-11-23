package com.app.model.socialconnections;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-20T13:23:54.030+0530")
@StaticMetamodel(AdminTwitterOAuth.class)
public class AdminTwitterOAuth_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<AdminTwitterOAuth, Integer> connectionId;
	public static volatile SingularAttribute<AdminTwitterOAuth, String> userId;
	public static volatile SingularAttribute<AdminTwitterOAuth, String> screenName;
	public static volatile SingularAttribute<AdminTwitterOAuth, String> accessToken;
	public static volatile SingularAttribute<AdminTwitterOAuth, String> accessTokenSecret;
}
