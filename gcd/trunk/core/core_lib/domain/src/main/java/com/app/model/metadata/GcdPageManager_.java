package com.app.model.metadata;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-28T19:47:04.134+0530")
@StaticMetamodel(GcdPageManager.class)
public class GcdPageManager_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<GcdPageManager, Integer> id;
	public static volatile SingularAttribute<GcdPageManager, String> pageUrl;
	public static volatile SingularAttribute<GcdPageManager, String> pageTitle;
	public static volatile SingularAttribute<GcdPageManager, String> pageText;
}
