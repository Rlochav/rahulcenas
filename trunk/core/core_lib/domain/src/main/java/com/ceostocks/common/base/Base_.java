package com.ceostocks.common.base;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-12T14:25:43.970+0530")
@StaticMetamodel(Base.class)
public class Base_ {
	public static volatile SingularAttribute<Base, BigDecimal> createdBy;
	public static volatile SingularAttribute<Base, Date> createdDate;
	public static volatile SingularAttribute<Base, BigDecimal> updatedBy;
	public static volatile SingularAttribute<Base, Date> updatedDate;
}
