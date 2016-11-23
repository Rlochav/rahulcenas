package com.app.model.getcitydealz;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-08T11:06:17.609+0530")
@StaticMetamodel(MerchantEmbeds.class)
public class MerchantEmbeds_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<MerchantEmbeds, Integer> embedId;
	public static volatile SingularAttribute<MerchantEmbeds, Integer> merchantId;
	public static volatile SingularAttribute<MerchantEmbeds, String> embedTitle;
	public static volatile SingularAttribute<MerchantEmbeds, String> embedContent;
	public static volatile SingularAttribute<MerchantEmbeds, Boolean> isShowOnPage;
}
