package com.leetcode.backtracking;

/**
 * Created by yizhao on 3/30/2018.
 */
public class Thread1 {
    public static void main(String[] args) {
        Runner1 r = new Runner1();
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread: "+ i);
        }

    }

}

class Runner1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner: "+ i);
        }
    }
}

class Runner2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner: "+ i);
        }
    }
}

