import sort.Sort;
import util.Counts;
import util.MyArrays;

import java.util.concurrent.ForkJoinPool;


public class Main {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        ForkJoinPool pool = new ForkJoinPool();
        int[] array1 = Sort.fillArray(MyArrays.HUNDRED_THOUSAND);
        startTime = System.currentTimeMillis();
        pool.invoke(new Sort(array1, 0, Counts.HUNDRED_THOUSAND - 1, Counts.HUNDRED_THOUSAND));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for sorting with FJP: " + (endTime - startTime) + " millis");
        int[] array2 = Sort.fillArray(MyArrays.HUNDRED_THOUSAND);
        startTime = System.currentTimeMillis();
        Sort.bubbleSort(Sort.fillArray(MyArrays.HUNDRED_THOUSAND), 0, Counts.HUNDRED_THOUSAND - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for sorting without FJP: " + (endTime - startTime) + " millis");

    }
}
