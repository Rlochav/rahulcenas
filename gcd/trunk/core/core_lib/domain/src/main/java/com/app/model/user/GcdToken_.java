package com.app.model.user;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.909+0530")
@StaticMetamodel(GcdToken.class)
public class GcdToken_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<GcdToken, Integer> tokenId;
	public static volatile SingularAttribute<GcdToken, Integer> tokenType;
	public static volatile SingularAttribute<GcdToken, String> tokenText;
}
