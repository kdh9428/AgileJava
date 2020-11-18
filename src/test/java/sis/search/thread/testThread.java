package sis.search.thread;

import org.junit.jupiter.api.Test;

public class testThread {

    @Test
    public void threadEx1(){

        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable runnable = new ThreadEx1_2();
        Thread thread = new Thread(runnable);

        t1.start();
        thread.start();
    }
}

class ThreadEx1_1 extends Thread{
    @Override
    public void run() {
        for (int i=0; i <5; i++){
            System.out.println(getName());
        }
    }
}

class ThreadEx1_2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}