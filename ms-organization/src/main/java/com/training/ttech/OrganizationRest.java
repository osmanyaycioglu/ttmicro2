package com.training.ttech;

import java.util.List;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ttech.feign.IEmployeeRest;

@RestController
@RequestMapping("/org")
public class OrganizationRest {

    @Autowired
    private RestTemplate   restTemplate;

    @Autowired
    private EurekaClient   ec;

    @Autowired
    private IEmployeeRest  er;

    @Autowired
    private RabbitTemplate rt;

    @GetMapping("/create/employee/{name}")
    public String createEmployee(@PathVariable("name") final String name) {
        String forObjectLoc = this.restTemplate.getForObject("http://EMPLOYEE/emp/greet/" + name,
                                                             String.class);
        return forObjectLoc;
    }

    @GetMapping("/create2/employee/{name}")
    public String createEmployee2(@PathVariable("name") final String name) {
        Application applicationLoc = this.ec.getApplication("EMPLOYEE");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }
        InstanceInfo nextServerFromEurekaLoc = this.ec.getNextServerFromEureka("EMPLOYEE",
                                                                               false);
        RestTemplate directTemplate = new RestTemplate();
        String forObjectLoc = directTemplate.getForObject("http://"
                                                          + nextServerFromEurekaLoc.getIPAddr()
                                                          + ":"
                                                          + nextServerFromEurekaLoc.getPort()
                                                          + "/emp/greet/"
                                                          + name,
                                                          String.class);
        return forObjectLoc;
    }

    @GetMapping("/create3/employee/{name}")
    public String createEmployee3(@PathVariable("name") final String name) {
        Department dep = new Department();
        dep.setName(name);
        dep.setEmployeeCount(new Random().nextInt());
        this.rt.convertAndSend("dep_direct_ex",
                               "dep_key",
                               dep);
        return this.er.greet(name);
    }

}
