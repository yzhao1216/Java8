package com.leetcode.backtracking;



/**
 * Created by yizhao on 3/30/2018.
 */
public class TestSync implements Runnable {
    Timer timer = new Timer();

    public static void main(String[] args) {
        TestSync test = new TestSync();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
class Timer{
    private static int num = 0;
    public void add(String name){
        //锁定当前对象 num
        synchronized (this){
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //被打断了，t2进来 改变了num的值，num=2了
            System.out.println(name+"you are "+ num +"use timmer");

        }
        }
}
