package sis.clock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockTest {

    private Clock clock;
    private Lock lock;
    private Condition receivedEnoughTics;
    private Object monitor = new Object();



    @BeforeEach
    void setUp() {
        lock = new ReentrantLock(); // ReentrantLock는 synchronized와 같다.
        receivedEnoughTics = lock.newCondition(); // 기존 동기화 위 monitor.wait() 등등 과 같은 역할
    }

    @Test
    public void testClock() throws InterruptedException {
        final int seconds = 5;
        final List<Date> tics = new ArrayList<>();
        ClockListener listener = createClockListener(tics, seconds);
        clock = new Clock(listener);
        lock.lock();

        try {
            receivedEnoughTics.await();
        } finally {
            lock.unlock();
        }

        clock.stop();
        verify(tics, seconds);
    }

    private ClockListener createClockListener(final List<Date> tics, final int seconds) {
        return new ClockListener() {
            private int count = 0;

            @Override
            public void update(Date date) {

                tics.add(date);
                if (++count == seconds) {
                    lock.lock();
                    try {
                        receivedEnoughTics.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
    }

    private void verify(List<Date> tics, int seconds) {
//        assertEquals(seconds, tics.size());

        for (int i = 1; i < seconds; i++) {
            assertEquals(1, getSecondsFromLast(tics, i));
        }
    }

    private long getSecondsFromLast(List<Date> tics, int i) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tics.get(i));
        int now = calendar.get(Calendar.SECOND);
        calendar.setTime(tics.get(i - 1));
        int then = calendar.get(Calendar.SECOND);

        if (now == 0)
            now = 60;

        return now - then;
    }


    @Test
    public void testDate() {

        Date date = new Date();

        System.out.println(date);


    }
}
