package com.leetcode.backtracking;

/**
 * Created by yizhao on 3/31/2018.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        new Thread(c).start();
    }
}

class Dough{
    int id;
    Dough(int id){
        this.id = id;
    }
    @Override
    public String toString() {
        return "Dou:"+id;
    }
}
class SyncStack{
    int index = 0;
    Dough[] douArr = new Dough[6];

    public synchronized void push(Dough dou){
        while (index == douArr.length){
            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        douArr[index] = dou;
        //这两句话之间不能被打断
        index++;
    }
    public synchronized Dough pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index --;
        return douArr[index];
    }
}

class Producer implements Runnable{
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Dough dou = new Dough(i);
            ss.push(dou);
            System.out.println("Produce: "+dou);
            try {
                Thread.sleep((long) (Math.random()*200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    SyncStack ss = null;
    Consumer(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Dough dou = ss.pop();
            System.out.println("Consume:"+dou);
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}