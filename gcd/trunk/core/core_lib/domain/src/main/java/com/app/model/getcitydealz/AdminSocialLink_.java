package com.app.model.getcitydealz;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.344+0530")
@StaticMetamodel(AdminSocialLink.class)
public class AdminSocialLink_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<AdminSocialLink, AdminSocialLinkPK> adminSocialLinkPK;
	public static volatile SingularAttribute<AdminSocialLink, String> fbFanPage;
	public static volatile SingularAttribute<AdminSocialLink, String> twitterAcc;
	public static volatile SingularAttribute<AdminSocialLink, String> consumerKey;
	public static volatile SingularAttribute<AdminSocialLink, String> consumerSecret;
	public static volatile SingularAttribute<AdminSocialLink, String> oAuthToken;
	public static volatile SingularAttribute<AdminSocialLink, String> oAuthSecret;
}
