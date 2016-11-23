package com.app.model.blog;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.230+0530")
@StaticMetamodel(GcdPost.class)
public class GcdPost_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<GcdPost, Integer> postId;
	public static volatile SingularAttribute<GcdPost, String> title;
	public static volatile SingularAttribute<GcdPost, String> post;
	public static volatile SingularAttribute<GcdPost, String> merchantId;
}
