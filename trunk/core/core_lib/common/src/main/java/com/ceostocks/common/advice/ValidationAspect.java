package com.ceostocks.common.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.ceostocks.common.exception.CeoValidationException;

@Aspect
public class ValidationAspect {

	@Pointcut("@annotation(com.ceostocks.common.annotation.Validate)")
	public void allMethods() {

	}

	@Before("allMethods()")
	public void validateBefore(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Object[] args = joinPoint.getArgs();
		try {
			System.out.println("Hi");
		} catch (Exception e) {
			throw new CeoValidationException();
		}
	}
}
