package com.ceostocks.mvc.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceostocks.application.cache.CacheApplication;
import com.ceostocks.common.util.CeoStocksConfigProperty;

@Component
public class CacheComponentImpl {

	private Map<String, Object> cacheMap = new HashMap<String, Object>();

	@Autowired
	private CacheApplication cacheApplication;

	public CacheComponentImpl() {
		//test();
	}

	public void test() {
		CeoStocksConfigProperty.getProperty("asd", "01");
		System.out.println("Hi");
	}
}
