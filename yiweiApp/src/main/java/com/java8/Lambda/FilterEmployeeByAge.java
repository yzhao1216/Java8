package com.java8.Lambda;

/**
 * Created by yizhao on 4/2/2018.
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee e) {
        return e.getAgd()>=35;
    }
}
