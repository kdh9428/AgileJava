package sis.search.thread;

public class ThreadEx9 {
    public static void main(String[] args) {

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");


        ThreadGroup subGrp1 = new ThreadGroup(grp1,"Group2");

        grp1.setMaxPriority(3);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("쓰레드 시작!" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
            }
        };

        new Thread(grp1, runnable, "th1").start();
        new Thread(subGrp1, runnable, "th2").start();
        new Thread(grp2, runnable, "th3").start();

        System.out.println(">List of ThreadGroup : "+ main.getName() + ", Active ThreadGroup : "+ main.activeGroupCount() + ", Active Thread : "+main.activeCount());

        main.list();
    }
}
