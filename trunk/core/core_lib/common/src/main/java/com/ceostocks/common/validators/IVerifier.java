package com.ceostocks.common.validators;

import java.lang.annotation.Annotation;

import com.ceostocks.common.exception.CeoValidationException;

public interface IVerifier {

	public void validate(Object param, Annotation annotation, Annotation methodAnnotation) throws CeoValidationException;

}
