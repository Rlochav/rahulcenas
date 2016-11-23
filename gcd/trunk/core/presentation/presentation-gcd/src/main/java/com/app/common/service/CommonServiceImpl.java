package com.app.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.common.dto.CacheDTO;
import com.app.common.manager.CommonManager;
import com.app.commonexception.BaseException;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private CommonManager commonManager;

	@Transactional(propagation = Propagation.NEVER)
	public CacheDTO getCacheDTO() throws BaseException {
		CacheDTO retDto = null;
		try {
			retDto = commonManager.getCacheDTO();
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

}
