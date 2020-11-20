package sis.search.thread;

import javax.swing.*;

public class ThreadEx13 {

    public static void main(String[] args) {

        ThreadEx13_1 t1 = new ThreadEx13_1();
        t1.start();

        String input = JOptionPane.showInputDialog("아무거나 입력");
        System.out.println("입력한 값은 : "+ input + " 입니다.");

        t1.interrupt();
        System.out.println("isInterrupted() : "+ t1.isInterrupted());

    }
}


class ThreadEx13_1 extends Thread{


    @Override
    public void run() {
        int i = 10;

        while (i != 0&& !isInterrupted()){
            System.out.println(i--);
            for (long x=0; x<2500000000L ; x++){

            }
        }
        System.out.println("카운트 다운 종료");
    }
}