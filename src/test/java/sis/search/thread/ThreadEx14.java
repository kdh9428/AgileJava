
package sis.search.thread;

import javax.swing.*;

public class ThreadEx14 {
    public static void main(String[] args) {

        ThreadEx14_1 t1 = new ThreadEx14_1();
        t1.start();

        String input =  JOptionPane.showInputDialog("아무 값이나 입력");
        System.out.println("입력하신 값은 " + input +" 입니다.");

        t1.interrupt();
        System.out.println("isInterrupted() : "+ t1.isInterrupted());

    }
}

class ThreadEx14_1 extends Thread {

    @Override
    public void run() {
        int i =10;
        while (i != 0 && !isInterrupted()){
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                interrupt();
            }
        }
            System.out.println("종료");
    }
}