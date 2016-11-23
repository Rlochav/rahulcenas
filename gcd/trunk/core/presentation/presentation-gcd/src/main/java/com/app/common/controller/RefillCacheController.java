package com.app.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.dto.CacheDTO;
import com.app.mvc.common.AppWebHandler;

@Controller
public class RefillCacheController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8206849188974935067L;

	@Autowired
	private RefillCacheLoader refillCacheLoader;

	private Map<String, CacheDTO> cacheDtoMap;

	@RequestMapping(value = "/refillCache")
	@ResponseBody
	public String refillCache(ModelMap modelMap) {
		if (cacheDtoMap == null || cacheDtoMap.get("cacheDto") == null || StringUtils.equals(getRequestParam("forcefull"), "true")) {
			cacheDtoMap = new HashMap<String, CacheDTO>();
			cacheDtoMap.put("cacheDto", refillCacheLoader.refillCache());
		}
		return "success";
	}

	public Map<String, CacheDTO> getCacheDtoMap() {
		return cacheDtoMap;
	}

	public void setCacheDtoMap(Map<String, CacheDTO> cacheDtoMap) {
		this.cacheDtoMap = cacheDtoMap;
	}

}
