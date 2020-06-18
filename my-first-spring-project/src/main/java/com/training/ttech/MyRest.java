package com.training.ttech;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRest {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/merhaba")
    public String helloWorld2() {
        return "hello2";
    }

    @PostMapping("/hello")
    public String helloWorld3() {
        return "hello post";
    }

    @GetMapping("/hello4/{abc}/{zxc}")
    public String helloWorld4(@PathVariable("abc") final String name,
                              @PathVariable("zxc") final String surname) {
        return "hello 4 : " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String helloWorld5(@RequestParam("abc") final String name,
                              @RequestParam("zxc") final String surname) {
        return "hello 5 : " + name + " " + surname;
    }

    @GetMapping("/hello6/{yas}")
    public String helloWorld6(@RequestHeader("abc") final String name,
                              @RequestHeader("zxc") final String surname,
                              @PathVariable("yas") final int age,
                              @RequestParam("gender") final String gender) {
        return "hello 6 : " + name + " " + surname + " " + age + " " + gender;
    }

    @PostMapping("/hello7")
    public String helloWorld7(@Validated @RequestBody final Person person) {
        return "hello 7 : " + person;
    }


    @PostMapping("/hello8")
    public String helloWorld8(@Validated @RequestBody final Person person) throws RestException {
        if (person.getName()
                  .equals("osman")) {
            throw new IllegalStateException("osman olamaz");
        } else if (person.getName()
                         .equals("ali")) {
            throw new RestException("ali olamaz");
        }

        return "hello 8 : " + person;
    }


}

