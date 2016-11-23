package com.app.model.socialconnections;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-28T02:48:18.683+0530")
@StaticMetamodel(TwitterOAuth.class)
public class TwitterOAuth_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<TwitterOAuth, Integer> merchantId;
	public static volatile SingularAttribute<TwitterOAuth, String> userId;
	public static volatile SingularAttribute<TwitterOAuth, String> screenName;
	public static volatile SingularAttribute<TwitterOAuth, String> accessToken;
	public static volatile SingularAttribute<TwitterOAuth, String> accessTokenSecret;
}
