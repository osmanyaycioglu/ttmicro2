package com.training.ttech;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({
          FIELD,
          METHOD
})
@Constraint(validatedBy = {
                            MyGenderValidator.class
})
public @interface CheckGender {

    String test();

    String message() default "Gender validation failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
