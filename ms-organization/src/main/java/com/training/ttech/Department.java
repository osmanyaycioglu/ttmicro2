package com.training.ttech;


public class Department {

    private String name;
    private int    employeeCount;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public void setEmployeeCount(final int employeeCountParam) {
        this.employeeCount = employeeCountParam;
    }

    @Override
    public String toString() {
        return "Department [name=" + this.name + ", employeeCount=" + this.employeeCount + "]";
    }


}
