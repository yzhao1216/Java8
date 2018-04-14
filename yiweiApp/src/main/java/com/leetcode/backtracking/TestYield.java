package com.leetcode.backtracking;

/**
 * Created by yizhao on 3/30/2018.
 */
public class TestYield {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("t1");
        MyThread3 t2 = new MyThread3("t2");
        t1.start();
        t2.start();
    }
}
class MyThread3 extends Thread{
    public MyThread3(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + ":"+i);
            if(i % 10 == 0){
                yield();
            }
        }
    }
}
