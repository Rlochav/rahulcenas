package com.ceostocks.services.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ceostocks.model.lkupcode.LkupCodeRepository;

@Service
public class CacheServiceImpl implements CacheService {

	private LkupCodeRepository lkupCodeRepository;

	@Override
	public Map<String, Object> getCache() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cache", lkupCodeRepository.getAll());
		return map;
	}
}
