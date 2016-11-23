package com.app.model.socialconnections;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:19.803+0530")
@StaticMetamodel(TwitterOAuthdetails.class)
public class TwitterOAuthdetails_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<TwitterOAuthdetails, TwitterOAuthdetailsPK> twitterOAuthdetailsPK;
	public static volatile SingularAttribute<TwitterOAuthdetails, String> ConsumerKey;
	public static volatile SingularAttribute<TwitterOAuthdetails, String> consumerSecret;
	public static volatile SingularAttribute<TwitterOAuthdetails, String> oAuthToken;
	public static volatile SingularAttribute<TwitterOAuthdetails, String> oAuthSecret;
}
