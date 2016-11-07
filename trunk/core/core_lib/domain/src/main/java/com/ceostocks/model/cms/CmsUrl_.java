package com.ceostocks.model.cms;

import com.ceostocks.common.base.Base_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-06T18:27:20.133+0530")
@StaticMetamodel(CmsUrl.class)
public class CmsUrl_ extends Base_ {
	public static volatile SingularAttribute<CmsUrl, Integer> id;
	public static volatile SingularAttribute<CmsUrl, String> name;
	public static volatile SingularAttribute<CmsUrl, Boolean> isActive;
	public static volatile SingularAttribute<CmsUrl, CmsUrlCategory> cmsUrlCategory;
}
