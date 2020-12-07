package sis.search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server extends Thread {

    private BlockingQueue<Search> queue = new LinkedBlockingQueue<Search>();

    private ResultsListener listener;

    public Server(ResultsListener listener) {
        this.listener = listener;
        start();
    }

    @Override
    public void run() {

        while (true) {
            try {
                execute(queue.take());
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void shutDown() throws Exception {
        this.interrupt();
    }

    public void add(Search search) throws Exception {
        queue.put(search);
    }

    private void execute(Search search) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                search.execute();
                listener.executed(search);
            }
        }).start();
    }
}
