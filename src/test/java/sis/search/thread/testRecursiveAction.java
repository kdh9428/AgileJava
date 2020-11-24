package sis.search.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class testRecursiveAction extends RecursiveAction {



    private long workLoad = 0;

    public testRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    public static void main(String[] args) {
        testRecursiveAction action = new testRecursiveAction(24);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(action);
    }

    @Override
    protected void compute() {

        if (this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<testRecursiveAction> subtasks = new ArrayList<>();

            subtasks.addAll(createSubtask());

            for (RecursiveAction subTask : subtasks) {
                subTask.fork();
            }
        } else {
            System.out.println("Doing workLoad Myself : " + this.workLoad);
        }


    }

    private List<testRecursiveAction> createSubtask() {
        List<testRecursiveAction> subtasks = new ArrayList<>();

        testRecursiveAction subtask1 = new testRecursiveAction(this.workLoad / 2);
        testRecursiveAction subtask2 = new testRecursiveAction(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);
        return subtasks;
    }
}
