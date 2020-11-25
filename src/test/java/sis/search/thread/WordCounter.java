package sis.search.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class WordCounter {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    Long countOccurrencesInParallel(ForkJoinFolder folder, String searchedWord) {
        return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
    }


    String[] wordsIn(String line) {
        return line.trim().split("(\\s|\\p{Punct})+");
    }

    Long occurrencesCount(ForkJoinDocument document, String searchedWord) {
        long count = 0;
        for (String line : document.getLines()) {
            for (String word : wordsIn(line)) {
                if (searchedWord.equals(word)) {
                    count += 1;
                }
            }
        }
        return count;
    }
}



class DocumentSearchTask extends RecursiveTask<Long> {

    private final ForkJoinDocument document;
    private final String searchedWord;

    public DocumentSearchTask(ForkJoinDocument document, String searchedWord) {
        this.document = document;
        this.searchedWord = searchedWord;
    }

    @Override
    protected Long compute() {
        return new WordCounter().occurrencesCount(document, searchedWord);
    }
}
