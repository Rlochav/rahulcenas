package com.ceostocks.common.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import com.ceostocks.common.exception.CeoStocksAppException;

public class CeoApplicationAspect {

	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object retVal = null;
		try {
			String name = jp.getSignature().getName();
			System.out.println(name);
			retVal = jp.proceed();
		} catch (Throwable e) {
			if (e instanceof CeoStocksAppException) {
				CeoStocksAppException ex = (CeoStocksAppException) e;
				throw ex;
			}
			throw e;
		}
		return retVal;
	}

}
