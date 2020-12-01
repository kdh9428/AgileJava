package sis.search.thread;

import javax.swing.*;
import java.sql.SQLOutput;

public class ThreadInterruptTest {

    public static void test1() {
        ThreadRun run = new ThreadRun();
        Thread thread1 = new Thread(run, "t1");
        Thread thread2 = new Thread(run, "t2");

        thread1.start();
        thread2.start();

        while (true) {
            String input = JOptionPane.showInputDialog("인터럽트할 스레드 넘버 선택, 1, 2 입력");
            int ipt = Integer.parseInt(input);

            switch (ipt) {
                case 1:
                    thread1.interrupt();
                    break;
                case 2:
                    thread2.interrupt();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        test1();
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true){
//                        System.out.println("실행중---");
//                        Thread.sleep(100);
//                    }
//                }catch (InterruptedException e){
//
//                }
//                System.out.println("자원 정리...");
//                System.out.println("실행 종료");
//            }
//
//        });
//
//        thread.start();
//        try {
//            Thread.sleep(5000);
//        }catch (InterruptedException e ){
//
//        }
//
//        System.out.println("스레드 인터럽트 시작 - ");
//        thread.interrupt();
//
//        System.out.println(thread.isInterrupted());

    }
}


class ThreadRun implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("[" + Thread.currentThread().getName() + " ] : sleep 상태로 변경");
//            Thread.sleep(1000 * 60 * 10);
        } catch (Exception e) {

            System.out.println("[" + Thread.currentThread().getName() + "] : InterruptedException 발생, 대기상태에서 빠져나온다.");
            System.out.println("[" + Thread.currentThread().getName() + "] : isInterrupted() : " + Thread.currentThread().isInterrupted());


        }
        int cnt = 0;
        while (true) {
            System.out.println("[" + Thread.currentThread().getName() + "] : 작업 수행 시작 : " + cnt++);
            for (long i = 0; i < 2500000000L; i++) {};

            System.out.println("[" + Thread.currentThread().getName() + "] : isInterrupted : " + Thread.currentThread().isInterrupted());
            if (Thread.interrupted() == true) break;
        }
            System.out.println("[" + Thread.currentThread().getName() + "] : 스레드 종료 : " + Thread.currentThread().isInterrupted());
    }
}