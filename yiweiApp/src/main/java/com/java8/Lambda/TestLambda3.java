package com.java8.Lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by yizhao on 4/10/2018.
 */
public class TestLambda3 {
    @Test
    public void test1(){
        List<Employee> employees = Arrays.asList(
                new Employee("a",18,9999.99),
                new Employee("b",19,5555.99),
                new Employee("c",42,8888.99),
                new Employee("d",50,9999.99),
                new Employee("e",18,3333.99)
        );
        Collections.sort(employees,(e1,e2)-> {
            if (e1.getAgd() == e2.getAgd()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAgd(),e2.getAgd());
            }
        });
        for (Employee emp : employees){
            System.out.println(emp);
        }
    }
}
