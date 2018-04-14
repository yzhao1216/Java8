package com.java8.Lambda;


import org.junit.Test;

import java.util.*;

/**
 * Created by yizhao on 4/2/2018.
 */
public class TestLambda {
    //anonymous class
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //lambda expression
    public void test2(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //需求：获取当前公司中员工年龄> 35 的员工信息

    List<Employee> employees = Arrays.asList(
            new Employee("a",18,9999.99),
            new Employee("b",19,5555.99),
            new Employee("c",42,8888.99),
            new Employee("d",50,9999.99),
            new Employee("e",18,3333.99)
    );

    @Test
    public void test3(){
        List<Employee> list = filterEmployee(employees);

        for (Employee employee: list) {
            System.out.println(employee);
        }
    }
    public List<Employee> filterEmployee(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for(Employee emp : list){
            if (emp.getAgd() >= 35){
                emps.add(emp);
            }
        }
        return emps;
    }
    //salary > 5000
    public List<Employee> filterSalary(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        Employee e = new Employee("aa",12,21);

        for(Employee emp : list){
            if (emp.getSalary() >= 5000){
                emps.add(emp);
            }
        }
        return emps;
    }


    //optimize1
    @Test
    public void test4(){
        List<Employee> list =fileEmployee(employees,new FilterEmployeeByAge());
        for(Employee e : list){
            System.out.println(e);
        }

        System.out.println("-----------");
        List<Employee> list2 = fileEmployee(employees,new FilterEmployeeBySalary());
        for (Employee e : list2){
            System.out.println(e);
        }
    }
    public List<Employee> fileEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list){
            if (mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }

    //optimize2 anonymous inner class

    @Test
    public void test5(){
        List<Employee> list= fileEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()<=5000;
            }
        });
        for (Employee e : list){
            System.out.println(e);
        }
    }

    // optimize3: Lambda expression

    @Test
    public void test6(){

        List<Employee> list = fileEmployee(employees, employee -> employee.getSalary()<=5000);
        list.forEach(System.out :: print);
    }

    // potimize4 : 除了employees, 其他啥都没有
    @Test
    public void test7(){
        employees.stream()
                .filter(employee -> employee.getSalary()>=5000)
                .forEach(System.out::println);
        System.out.println("-------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


}
