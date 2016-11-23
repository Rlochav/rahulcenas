package com.app.model.salesperson;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-29T06:33:17.858+0530")
@StaticMetamodel(SalesPerson.class)
public class SalesPerson_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<SalesPerson, Integer> salesPersonId;
	public static volatile SingularAttribute<SalesPerson, String> salesPersonFirstName;
	public static volatile SingularAttribute<SalesPerson, String> salesPersonLastName;
	public static volatile SingularAttribute<SalesPerson, Integer> status;
}
