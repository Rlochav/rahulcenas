package com.ceostocks.model.ecom;

import com.ceostocks.common.base.Base_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-28T23:46:33.062+0530")
@StaticMetamodel(Category.class)
public class Category_ extends Base_ {
	public static volatile SingularAttribute<Category, Integer> categoryId;
	public static volatile SingularAttribute<Category, String> categoryName;
	public static volatile SingularAttribute<Category, String> categoryCode;
	public static volatile SetAttribute<Category, Category> categories;
	public static volatile SingularAttribute<Category, Category> category;
	public static volatile SetAttribute<Category, Product> products;
}
