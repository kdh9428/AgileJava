package sis.search.thread;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {

    static final ForkJoinPool POOL = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L, to = 30L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        long result = POOL.invoke(task);

        System.out.println("Elapsed time (4 Core) : " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();

        for (long i = from; i <= to; i++) {
            result += i;
        }

        System.out.println("Elapsed time(1 Core) : " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
    }
}


class SumTask extends RecursiveTask<Long> {
    long from, to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long size = to - from + 1; // from <= i <= to
        if (size <= 5)
            return sum();

        long half = (from + to) / 2;

        System.out.println("half의 변화 추적 : "+ half);
        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half + 1, to);

        leftSum.fork();
        rightSum.fork();
        long l = rightSum.join();
        long join = leftSum.join();
        System.out.println("결과 값  l : " + l + ", join : ");

        return l + join;
    }

    long sum() {
        long tmp = 0L;

        for (long i = from; i <= to; i++) {
            tmp += i;
        }
        System.out.println("sum 함수 : "+tmp);
        System.out.println("스레드 확인 : "+ Thread.currentThread());
        return tmp;
    }
}