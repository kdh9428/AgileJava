package sis.search;

import java.util.LinkedList;
import java.util.List;

public class Server extends Thread {

    private List<Search> queue = new LinkedList<>(); //문제 발생
    private ResultsListener listener;

    public Server(ResultsListener listener) {
        this.listener = listener;
        start();
    }

    @Override
    public void run() {

        while (true) {
            if (!queue.isEmpty())
                execute(queue.remove(0));
            Thread.yield(); //백그라운드 쓰레드가 실행되기 전에 다른 쓰레드가 프로세서를 사용하도록 허용한다.
        }
    }

    public void add(Search search) {
        queue.add(search);
    }

    private void execute(Search search) {
        search.execute();
        listener.executed(search);
    }

}
