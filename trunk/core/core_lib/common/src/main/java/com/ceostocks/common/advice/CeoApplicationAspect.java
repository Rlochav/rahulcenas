package com.ceostocks.common.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.ceostocks.common.exception.CeoStocksAppException;

@Aspect
public class CeoApplicationAspect {

	@Around("@annotation(com.ceostocks.common.annotation.CeoStocksReqNewTxn)")
	public Object arround(ProceedingJoinPoint jp) throws Throwable {
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

	@Around("@annotation(com.ceostocks.common.annotation.CeoStocksReadOnlyTxn)")
	public Object arround1(ProceedingJoinPoint jp) throws Throwable {
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
