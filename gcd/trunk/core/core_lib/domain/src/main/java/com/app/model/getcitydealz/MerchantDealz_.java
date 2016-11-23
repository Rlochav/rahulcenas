package com.app.model.getcitydealz;

import com.app.model.base.BaseNoUDF_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-28T19:47:19.325+0530")
@StaticMetamodel(MerchantDealz.class)
public class MerchantDealz_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<MerchantDealz, MerchantDealzPK> merchantDealzPK;
	public static volatile SingularAttribute<MerchantDealz, Date> startDate;
	public static volatile SingularAttribute<MerchantDealz, Date> endDate;
	public static volatile SingularAttribute<MerchantDealz, String> code;
	public static volatile SingularAttribute<MerchantDealz, String> title;
	public static volatile SingularAttribute<MerchantDealz, String> description;
	public static volatile SingularAttribute<MerchantDealz, String> amountSaving;
	public static volatile SingularAttribute<MerchantDealz, String> restrictions;
	public static volatile SingularAttribute<MerchantDealz, String> imageUrl;
	public static volatile SingularAttribute<MerchantDealz, Integer> useLogo;
	public static volatile SingularAttribute<MerchantDealz, Integer> dealType;
	public static volatile SingularAttribute<MerchantDealz, String> latitude;
	public static volatile SingularAttribute<MerchantDealz, String> longitude;
	public static volatile SingularAttribute<MerchantDealz, Integer> processed;
	public static volatile SingularAttribute<MerchantDealz, Integer> payed;
	public static volatile SingularAttribute<MerchantDealz, String> localTimeZoneName;
	public static volatile SingularAttribute<MerchantDealz, String> localTimeZoneUtc;
	public static volatile SingularAttribute<MerchantDealz, String> fbSortUrl;
	public static volatile SingularAttribute<MerchantDealz, String> twitSortUrl;
	public static volatile SingularAttribute<MerchantDealz, String> pinSortUrl;
	public static volatile SingularAttribute<MerchantDealz, String> linkSortUrl;
	public static volatile SingularAttribute<MerchantDealz, String> gPSortUrl;
	public static volatile SingularAttribute<MerchantDealz, Integer> status;
	public static volatile SingularAttribute<MerchantDealz, String> hotDealLink;
	public static volatile SingularAttribute<MerchantDealz, Integer> hotDealOrder;
	public static volatile SingularAttribute<MerchantDealz, Integer> adminSocialPostedStatus;
}
