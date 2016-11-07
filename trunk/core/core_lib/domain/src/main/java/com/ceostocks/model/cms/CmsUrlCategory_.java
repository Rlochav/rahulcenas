package com.ceostocks.model.cms;

import com.ceostocks.common.base.Base_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-06T19:54:53.130+0530")
@StaticMetamodel(CmsUrlCategory.class)
public class CmsUrlCategory_ extends Base_ {
	public static volatile SingularAttribute<CmsUrlCategory, Integer> id;
	public static volatile SingularAttribute<CmsUrlCategory, String> name;
	public static volatile SingularAttribute<CmsUrlCategory, Boolean> isActive;
	public static volatile SetAttribute<CmsUrlCategory, CmsUrl> cmsUrls;
	public static volatile SingularAttribute<CmsUrlCategory, Integer> categoryType;
}
