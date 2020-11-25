package sis.search.thread;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class TestMain {

    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter();
        ForkJoinFolder folder = ForkJoinFolder.fromDirectory(new File(args[0]));
//        System.out.println(wordCounter.countOccurrencesOnSingleThread(folder, args[1]));
    }

}
