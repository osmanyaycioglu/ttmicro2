package com.training.ttech;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyGenderValidator implements ConstraintValidator<CheckGender, String> {

    private CheckGender gender;

    @Override
    public void initialize(final CheckGender genderParam) {
        this.gender = genderParam;
        System.out.println("test : " + this.gender.test());
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        String messageLoc = this.gender.message();
        if (valueParam.equalsIgnoreCase("ERKEK") || valueParam.equalsIgnoreCase("KADIN")) {
            return true;
        }
        return false;
    }

}
