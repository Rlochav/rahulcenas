package com.app.model.socialconnections;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-20T13:25:32.527+0530")
@StaticMetamodel(SocialAccounts.class)
public class SocialAccounts_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<SocialAccounts, Integer> id;
	public static volatile SingularAttribute<SocialAccounts, String> emailId;
	public static volatile SingularAttribute<SocialAccounts, String> firstName;
	public static volatile SingularAttribute<SocialAccounts, String> lastName;
	public static volatile SingularAttribute<SocialAccounts, String> account;
}
