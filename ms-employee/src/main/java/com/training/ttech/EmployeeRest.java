package com.training.ttech;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeRest {

    @Value("${server.port}")
    private int port;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable("name") final String name) {
        return this.port + " Hello " + name;
    }

}
