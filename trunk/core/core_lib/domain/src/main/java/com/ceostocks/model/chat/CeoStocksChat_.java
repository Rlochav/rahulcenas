package com.ceostocks.model.chat;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-26T22:35:17.905+0530")
@StaticMetamodel(CeoStocksChat.class)
public class CeoStocksChat_ {
	public static volatile SingularAttribute<CeoStocksChat, Integer> id;
	public static volatile SingularAttribute<CeoStocksChat, String> userFrom;
	public static volatile SingularAttribute<CeoStocksChat, String> userTo;
	public static volatile SingularAttribute<CeoStocksChat, String> message;
	public static volatile SingularAttribute<CeoStocksChat, String> messageState;
	public static volatile SingularAttribute<CeoStocksChat, Date> messageTime;
}
