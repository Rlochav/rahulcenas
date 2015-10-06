package com.ceostocks.application.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.services.cache.CacheService;

public class CacheApplicationImpl implements CacheApplication {

	@Autowired
	private CacheService cacheService;

	@CeoStocksReadOnlyTxn
	@Override
	public Map<String, Object> getCache() {

		return cacheService.getCache();
	}

}
