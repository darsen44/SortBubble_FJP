package sort;

import java.util.concurrent.RecursiveAction;

public class Sort extends RecursiveAction {

    private int[] array;
    private int end;
    private int start;
    private int count;

    public Sort(int[] array, int start, int end, int count) {
        this.array = array;
        this.end = end;
        this.start = start;
        this.count = count;
    }

    @Override
    protected void compute() {
        if ((end - start) <= count >>> 1) {
            bubbleSort(array, start, end);
        } else {
            int middle = (end - start) >>> 1;
            invokeAll(new Sort(array, start, middle, count),
                    new Sort(array, middle, end, count));
            merge(array, start, end);
        }
    }

    private void merge(int[] array, int start, int end) {
        int middle = (end - start) >>> 1;
        int[] ar1 = new int[middle];
        int[] ar2 = new int[middle];
        System.arraycopy(array, start, ar1, 0, middle);
        System.arraycopy(array, middle, ar2, 0, middle);

        int i = 0, j = 0, k = 0;
        while (i < middle && j < middle) {
            if (ar1[i] < ar2[j]) {
                array[k] = ar1[i];
                i++;
                k++;
            } else {
                array[k] = ar2[j];
                j++;
                k++;
            }

        }
    }


    public static void bubbleSort(int[] numArray, int start, int end) {
        boolean run = true;
        int temp;

        while (run) {
            run = false;
            for (int i = start; i < end - 1; i++) {
                if (numArray[i] > numArray[i + 1]) {
                    temp = numArray[i];
                    numArray[i] = numArray[i + 1];
                    numArray[i + 1] = temp;
                    run = true;
                }
            }
        }
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

}
