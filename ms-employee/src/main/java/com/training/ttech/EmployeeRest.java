package com.training.ttech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeRest {

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable("name") final String name) {
        return "Hello " + name;
    }

}
