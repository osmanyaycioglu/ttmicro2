package com.training.ttech.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "employee")
@RequestMapping("/emp")
public interface IEmployeeRest {

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable("name") final String name);
}
