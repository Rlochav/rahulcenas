package com.app.common.service;

import com.app.common.dto.CacheDTO;
import com.app.commonexception.BaseException;

public interface CommonService {

	public CacheDTO getCacheDTO() throws BaseException;

}
