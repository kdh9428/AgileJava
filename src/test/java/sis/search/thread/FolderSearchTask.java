package sis.search.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSearchTask extends RecursiveTask<Long> {

    private final ForkJoinFolder folder;
    private final String searchedWord;

    public FolderSearchTask(ForkJoinFolder folder, String searchWord) {
        this.folder = folder;
        this.searchedWord = searchWord;
    }

    @Override
    protected Long compute() {
        long count = 0L;
        List<RecursiveTask<Long>> forks = new LinkedList<>();

        for (ForkJoinFolder subFolder : folder.getSubFolders()) {
            FolderSearchTask task = new FolderSearchTask(subFolder, searchedWord);
            forks.add(task);
        }

        for (ForkJoinDocument document : folder.getDocuments()){
            DocumentSearchTask task = new DocumentSearchTask(document, searchedWord);
            task.fork();
        }

        for (RecursiveTask<Long> task : forks){
            count = count + task.join();
        }

        return count;
    }
}
