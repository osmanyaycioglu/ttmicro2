package com.training.ttech.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer1/v1")
public class Customer1 {

    @PutMapping
    public String add(@RequestBody final Customer cust) {
        return "OK";
    }

    @DeleteMapping
    public String remove(@RequestBody final Customer cust) {
        return "OK";
    }

    @PatchMapping
    public String update(@RequestBody final Customer cust) {
        return "OK";
    }

    @GetMapping
    public Customer1 get(final String id) {
        return null;
    }

}
