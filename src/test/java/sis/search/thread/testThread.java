package sis.search.thread;

import org.junit.jupiter.api.Test;

import javax.swing.*;

public class testThread {

    static long startTime;

    @Test
    public void threadEx1() {

        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable runnable = new ThreadEx1_2();
        Thread thread = new Thread(runnable);

        t1.start();
        thread.start();
    }

    @Test
    public void testThreadEx2() {

        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();

    }

    @Test
    public void testThreadEx3() {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
    }

    @Test
    public void testThreadEx4() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.print("소요시간1 : " + (System.currentTimeMillis() - startTime));

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testThreadEx5() {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();

        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.print("소요시간1 : " + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testThreadEx7() {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + " 입니다.");

    }

    @Test
    public void testThreadEx8() {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();

        th2.setPriority(7);

        System.out.println("Priority of th1 (-) : " + th1.getPriority());
        System.out.println("Priority of th2 (|) : " + th2.getPriority());

        th1.start();
        th2.start();

    }
}

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

class ThreadEx1_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class ThreadEx2_1 extends Thread {

    @Override
    public void run() {
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadEx3_1 extends Thread {

    @Override
    public void run() {
        throwException();
    }

    private void throwException() {

        try {
            throw new Exception("Ex3 예외");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadEx5_1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간2 : " + (System.currentTimeMillis() - testThread.startTime));
    }
}

class ThreadEx7_1 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadEx8_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++) {

            }
        }
    }
}

class ThreadEx8_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++) ;
        }
    }
}

