package com.leetcode.backtracking;

/**
 * Created by yizhao on 3/30/2018.
 */
public class TestPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        t1.setPriority(Thread.NORM_PRIORITY + 4);
        t1.start();
        t2.start();
    }
}

class T1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("T1:" + i);
        }
    }
}
class T2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("---------T2:" + i);
        }
    }
}