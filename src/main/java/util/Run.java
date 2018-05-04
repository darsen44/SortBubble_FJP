package util;

import sort.Sort;

import java.util.concurrent.ForkJoinPool;

public class Run {

    private static long startTime, endTime;

    public static void runSortFJP() {
        ForkJoinPool pool = new ForkJoinPool();
        startTime = System.currentTimeMillis();
        pool.invoke(new Sort(Sort.fillArray(MyArrays.HUNDRED_THOUSAND), 0, Counts.HUNDRED_THOUSAND - 1, Counts.HUNDRED_THOUSAND));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for sorting with FJP: " + (endTime - startTime) + " millis");
    }

    public static void runSortBubble() {
        startTime = System.currentTimeMillis();
        Sort.bubbleSort(Sort.fillArray(MyArrays.HUNDRED_THOUSAND), 0, Counts.HUNDRED_THOUSAND - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for sorting without FJP: " + (endTime - startTime) + " millis");
    }
}
