package com.java8.Lambda;

/**
 * Created by yizhao on 4/2/2018.
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary()>=5000;
    }
}
