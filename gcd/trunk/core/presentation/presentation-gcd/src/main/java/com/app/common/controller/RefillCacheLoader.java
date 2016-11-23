package com.app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.dto.CacheDTO;
import com.app.common.service.CommonService;
import com.app.commonexception.BaseException;

@Service
public class RefillCacheLoader {
	@Autowired
	private CommonService commonService;

	public CacheDTO refillCache() {
		try {
			CacheDTO cacheObj = commonService.getCacheDTO();
			return cacheObj;
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof BaseException) {
			} else if (e.getCause() != null && e.getCause() instanceof BaseException) {
			} else {
				e.printStackTrace();
			}
		}
		return null;
	}
}
