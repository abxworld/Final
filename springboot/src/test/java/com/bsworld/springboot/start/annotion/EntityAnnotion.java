package com.bsworld.springboot.start.annotion;
/*
*author: xieziyang
*date: 2018/8/2
*time: 15:35
*description:
*/

import com.bsworld.springboot.annotion.BNotNull;
import com.bsworld.springboot.entity.PersonEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntityAnnotion implements ConstraintValidator<BNotNull, PersonEntity> {
    BNotNull bNotNull;

    @Override
    public void initialize(BNotNull constraintAnnotation) {
        this.bNotNull = constraintAnnotation;
    }

    @Override
    public boolean isValid(PersonEntity personEntity, ConstraintValidatorContext constraintValidatorContext) {

        return false;
    }


}
