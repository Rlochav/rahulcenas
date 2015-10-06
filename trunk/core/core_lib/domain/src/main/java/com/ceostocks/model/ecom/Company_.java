package com.ceostocks.model.ecom;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.user.UserMaster;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-26T13:31:33.247+0530")
@StaticMetamodel(Company.class)
public class Company_ extends Base_ {
	public static volatile SingularAttribute<Company, BigDecimal> companyId;
	public static volatile SingularAttribute<Company, String> companyCode;
	public static volatile SingularAttribute<Company, String> tinNumber;
	public static volatile SingularAttribute<Company, String> companyName;
	public static volatile SingularAttribute<Company, String> emailAddress;
	public static volatile SingularAttribute<Company, String> companyAddressLine1;
	public static volatile SingularAttribute<Company, String> companyAddressLine2;
	public static volatile SingularAttribute<Company, String> companyAddressLine3;
	public static volatile SingularAttribute<Company, String> contactPersonName;
	public static volatile SingularAttribute<Company, String> phoneNumber;
	public static volatile SingularAttribute<Company, String> mobileNo;
	public static volatile SingularAttribute<Company, UserMaster> userMaster;
}
