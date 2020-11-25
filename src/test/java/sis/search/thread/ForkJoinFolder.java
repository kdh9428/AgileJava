package sis.search.thread;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ForkJoinFolder {
    private final List<ForkJoinFolder> subFolders;
    private final List<ForkJoinDocument> documents;

    public ForkJoinFolder(List<ForkJoinFolder> subFolders, List<ForkJoinDocument> documents) {
        this.subFolders = subFolders;
        this.documents = documents;
    }

    List<ForkJoinFolder> getSubFolders() {
        return this.subFolders;
    }

    List<ForkJoinDocument> getDocuments() {
        return this.documents;
    }

    static ForkJoinFolder fromDirectory(File dir) throws IOException {
        List<ForkJoinDocument> documents = new LinkedList<>();
        List<ForkJoinFolder> subFolders = new LinkedList<>();

        for (File entry : dir.listFiles()) {
            if (entry.isDirectory()){
                subFolders.add(ForkJoinFolder.fromDirectory(entry));
            }else{
                documents.add(ForkJoinDocument.fromFile(entry));
            }
        }

        return new ForkJoinFolder(subFolders, documents);
    }
}
