package com.ceostocks.common.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceostocks.common.annotation.CeoNotNull;

public class CeoNotNullValidator implements ConstraintValidator<CeoNotNull, Object> {

	@Override
	public void initialize(CeoNotNull arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
		if (object != null)
			return true;
		return false;
	}

}
