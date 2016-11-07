package com.ceostocks.model.cms;

import com.ceostocks.common.base.Base_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-06T16:46:07.392+0530")
@StaticMetamodel(CmsPage.class)
public class CmsPage_ extends Base_ {
	public static volatile SingularAttribute<CmsPage, Integer> id;
	public static volatile SingularAttribute<CmsPage, String> name;
	public static volatile SingularAttribute<CmsPage, String> desciption;
	public static volatile SingularAttribute<CmsPage, CmsPageContent> cmsPageContent;
	public static volatile SingularAttribute<CmsPage, Boolean> isActive;
}
