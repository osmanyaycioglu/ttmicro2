package com.training.ttech;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {

    @NotEmpty
    @Size(min = 2, max = 30, message = "name 2 ile 30 arasında olmalı")
    private String  name;
    @NotEmpty
    @Size(min = 2, max = 30, message = "surname 2 ile 30 arasında olmalı")
    private String  surname;
    @Max(120)
    @Min(value = 18, message = "age 18 den küçük olamaz")
    @NotNull
    private Integer age;
    @NotEmpty
    @CheckGender(test = "my test str")
    private String  gender;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }


    public String getGender() {
        return this.gender;
    }

    public void setGender(final String genderParam) {
        this.gender = genderParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", age="
               + this.getAge()
               + ", gender="
               + this.gender
               + "]";
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }


}
