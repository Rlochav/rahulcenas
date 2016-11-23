package com.app.model.getcitydealz;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.686+0530")
@StaticMetamodel(MerchantLocation.class)
public class MerchantLocation_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<MerchantLocation, MerchantLocationPK> merchantLocationPK;
	public static volatile SingularAttribute<MerchantLocation, String> locationName;
	public static volatile SingularAttribute<MerchantLocation, String> contactFirstName;
	public static volatile SingularAttribute<MerchantLocation, String> contactLastName;
	public static volatile SingularAttribute<MerchantLocation, String> locationPhone;
	public static volatile SingularAttribute<MerchantLocation, String> address1;
	public static volatile SingularAttribute<MerchantLocation, String> address2;
	public static volatile SingularAttribute<MerchantLocation, String> address3;
	public static volatile SingularAttribute<MerchantLocation, String> city;
	public static volatile SingularAttribute<MerchantLocation, String> state;
	public static volatile SingularAttribute<MerchantLocation, String> zipCode;
	public static volatile SingularAttribute<MerchantLocation, String> email;
	public static volatile SingularAttribute<MerchantLocation, String> locationDesc;
	public static volatile SingularAttribute<MerchantLocation, String> locationHours;
	public static volatile SingularAttribute<MerchantLocation, Integer> neighborhoodid;
}
