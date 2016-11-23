package com.app.model.category;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:18.950+0530")
@StaticMetamodel(MasterCategory.class)
public class MasterCategory_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<MasterCategory, Integer> categoryId;
	public static volatile SingularAttribute<MasterCategory, String> categoryName;
	public static volatile SingularAttribute<MasterCategory, String> isActive;
}
