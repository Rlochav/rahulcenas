package com.ceostocks.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.NEVER)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CeoStocksReadOnlyTxn {

}
