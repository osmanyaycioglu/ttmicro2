package com.training.ttech;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> innerError;
    private String         subDomain;
    private String         boundedContext;
    private String         microservice;
    private String         description;


    public ErrorObj() {
    }

    public ErrorObj(final String subDomainParam,
                    final String boundedContextParam,
                    final String microserviceParam,
                    final String descriptionParam) {
        super();
        this.subDomain = subDomainParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.description = descriptionParam;
    }

    public void addInnerError(final ErrorObj errorObjParam) {
        if (this.innerError == null) {
            this.innerError = new ArrayList<>();
        }
        this.innerError.add(errorObjParam);
    }

    public List<ErrorObj> getInnerError() {
        return this.innerError;
    }

    public void setInnerError(final List<ErrorObj> innerErrorParam) {
        this.innerError = innerErrorParam;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public void setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public void setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String descriptionParam) {
        this.description = descriptionParam;
    }


}
