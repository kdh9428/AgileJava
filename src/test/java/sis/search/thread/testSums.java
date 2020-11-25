package sis.search.thread;

import java.lang.invoke.CallSite;
import java.util.List;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

public class testSums {

    static class Sum implements Callable<Long> {

        private final long from;
        private final long to;

        public Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long acc = 0;

            for (long i = from; i < to; i++) {
                acc = acc + i;
            }
            return acc;
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future<Long>> results = executor.invokeAll(asList(new testSums.Sum(0, 10), new Sum(100, 1_000), new Sum(10_000, 1_000_000)));
        executor.shutdown();

        for (Future<Long> result : results){
            System.out.println(result.get());
        }

    }
}
