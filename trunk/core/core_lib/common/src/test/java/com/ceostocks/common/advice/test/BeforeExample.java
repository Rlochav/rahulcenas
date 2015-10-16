package com.ceostocks.common.advice.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExample {

	@Before("execution(* com.ceostocks.common.advice.test.CustomerBo.addCustomer(..))")
	public void before(JoinPoint jp) {
		System.out.println(jp.getSignature().getName());
	}

	@After("execution(* com.ceostocks.common.advice.test.CustomerBo.addCustomer(..))")
	public void after(JoinPoint jp) {
		System.out.println("@After: " + jp.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* com.ceostocks.common.advice.test.CustomerBo.addCustomerReturnValue(..))", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		System.out.println("@AfterReturning: " + jp.getSignature().getName());
		System.out.println("result: " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.ceostocks.common.advice.test.CustomerBo.addCustomerThrowException(..))", throwing = "ex")
	public void afterThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("@AfterThrowing: " + jp.getSignature().getName());
		System.out.println("throwing: " + ex);
	}

	@Around(value = "execution(* com.ceostocks.common.advice.test.CustomerBo.addCustomerAround(..))")
	public Object arround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("@Around: " + jp.getSignature().getName());
		System.out.println(jp.proceed());
		return jp.proceed();
	}
}
