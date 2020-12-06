package sis.clock;

import java.util.Date;

public class Clock implements Runnable {

    private ClockListener listener;
    private boolean run = true;

    public Clock(ClockListener listener) {
        this.listener = listener;
        new Thread(this).start();
    }

    public void stop() {
        run = false;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY - 1);
        long lastTime = System.currentTimeMillis();
        System.out.println(lastTime);
        while (run) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long now = System.currentTimeMillis();

            long l = (now / 1000) - (lastTime / 1000);
            System.out.println("시간측정: " + now);
            System.out.println("계산 : " + l);
            if ((now / 1000) - (lastTime / 1000) >= 1) {
                listener.update(new Date(now));
                lastTime = now;
            }
        }
    }
}
