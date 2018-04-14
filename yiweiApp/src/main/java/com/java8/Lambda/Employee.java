package com.java8.Lambda;

/**
 * Created by yizhao on 4/2/2018.
 */
public class Employee {
    private String name;
    private int agd;
    private double salary;

    public Employee(String name, int agd, double salary) {
        this.name = name;
        this.agd = agd;
        this.salary = salary;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAgd(int agd) {
        this.agd = agd;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAgd() {
        return agd;
    }

    public double getSalary() {
        return salary;
    }
}
