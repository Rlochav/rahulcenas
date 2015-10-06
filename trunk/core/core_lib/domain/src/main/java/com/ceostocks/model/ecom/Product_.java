package com.ceostocks.model.ecom;

import com.ceostocks.common.base.Base_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-28T23:39:04.351+0530")
@StaticMetamodel(Product.class)
public class Product_ extends Base_ {
	public static volatile SingularAttribute<Product, BigDecimal> id;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, String> productCode;
	public static volatile SingularAttribute<Product, String> productPrice;
	public static volatile SetAttribute<Product, Category> categories;
}
