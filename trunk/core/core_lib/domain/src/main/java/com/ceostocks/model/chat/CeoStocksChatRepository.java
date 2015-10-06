package com.ceostocks.model.chat;

import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface CeoStocksChatRepository extends BaseDao<CeoStocksChat, Integer> {

	List<CeoStocksChat> getUserChat(String firstName);

}
