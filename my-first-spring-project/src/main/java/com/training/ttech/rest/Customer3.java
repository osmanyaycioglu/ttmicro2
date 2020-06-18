package com.training.ttech.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer2/v2")
public class Customer3 {

    @PostMapping("/add")
    public String add(@RequestBody final Customer cust) {
        return "OK";
    }

    @PostMapping("/remove")
    public String remove(@RequestBody final Customer cust) {
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Customer cust) {
        return "OK";
    }

    @GetMapping("/get")
    public Customer3 get(final String id) {
        return null;
    }

    @PostMapping("/validate")
    public String validate(@RequestBody final Customer cust) {
        return "OK";
    }

}
