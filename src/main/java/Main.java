import sort.Sort;
import util.Counts;
import util.MyArrays;

import java.util.concurrent.ForkJoinPool;


public class Main {

    public static void main(String[] args) {
        long startTime, endTime;
        ForkJoinPool pool = new ForkJoinPool();
        startTime = System.currentTimeMillis();
        pool.invoke(new Sort(Sort.fillArray(MyArrays.HUNDRED_THOUSAND), 0, Counts.HUNDRED_THOUSAND - 1, Counts.HUNDRED_THOUSAND));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for sorting with FJP: " + (endTime - startTime) + " millis");
        startTime = System.currentTimeMillis();
        Sort.bubbleSort(Sort.fillArray(MyArrays.HUNDRED_THOUSAND), 0, Counts.HUNDRED_THOUSAND - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for sorting without FJP: " + (endTime - startTime) + " millis");
    }
}
