package sis.search.thread;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class FolderProcessorMainTest {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
        FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");

        pool.execute(system);
        List<String> app = pool.invoke(apps);
        List<String> document = pool.invoke(documents);


        do {
            System.out.println("**************************");
            System.out.printf("Main : Parallelism : %d\n", pool.getParallelism());
            System.out.printf("Main : Active Threads(활성 스레드 수) : %d\n", pool.getActiveThreadCount());
            System.out.printf("Main : Task Count(대기 작업 수) : %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main : Steal Count(가져온 작업 수) : %d\n", pool.getStealCount());
            System.out.println("**************************");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!system.isDone() || (!apps.isDone()) || (!documents.isDone())));

        List<String> results = system.join();
        System.out.printf("System : %d files found.\n ", results.size());
//        results = apps.join();
        System.out.printf("Apps : %d files found. \n", app.size());
//        results = documents.join();
        System.out.printf("Documents : %d files found. \n", document.size());
        pool.shutdown();
    }
}
