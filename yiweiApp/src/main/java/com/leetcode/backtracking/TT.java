package com.leetcode.backtracking;

/**
 * Created by yizhao on 3/31/2018.
 */
public class TT implements Runnable{
    int b = 100;

    public synchronized void m1(){
        b = 1000;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B=" + b);
    }
    //m2 方法没有被锁定个，所以另一个线程可以访问m2
    public synchronized void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b = 2000;
    }

    @Override
    public void run() {
        try {
            m1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TT t = new TT();
        Thread t1 = new Thread(t);
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.m2();
        System.out.println(t.b);
    }
}
