package com.leetcode.backtracking;

import java.io.InterruptedIOException;
import java.util.Date;

/**
 * Created by yizhao on 3/30/2018.
 */
public class TestInterrupt {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

class MyThread extends Thread {
    public void run() {
        while (true) {
            System.out.println(new Date());
            try {
                sleep(1000);

            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
