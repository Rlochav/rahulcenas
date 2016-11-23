package com.app.model.user;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-22T13:03:03.681+0530")
@StaticMetamodel(GCDtransaction.class)
public class GCDtransaction_ {
	public static volatile SingularAttribute<GCDtransaction, GCDtransactionPK> dtransactionPK;
	public static volatile SingularAttribute<GCDtransaction, Date> dealStartTime;
	public static volatile SingularAttribute<GCDtransaction, Date> emailTriggerTime;
	public static volatile SingularAttribute<GCDtransaction, Integer> deliveryStatus;
}
