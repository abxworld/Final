package com.bsworld.springboot.annotion;
/*
*author: xieziyang
*date: 2018/8/2
*time: 15:34
*description:
*/

import javax.validation.Payload;
import java.lang.annotation.*;

//@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BNotNull.List.class)
@Documented
public @interface BNotNull {
    String message() default "";

    String fieldName() default "";

    String condition() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        BNotNull[] value();
    }
}
