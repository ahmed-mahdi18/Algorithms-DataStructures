// -------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author ahmed mahdi
 *  @version HT 2022
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double[] a){
        double temp;
        for (int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        return a;

    }

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double[] a) {
        int k = a.length;
        for (int i = 0; i < k - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < k; j++) {
                if (a[j] < a[minimumIndex])
                    minimumIndex = j;
            }
            double temp = a[minimumIndex];
            a[minimumIndex] = a[i];
            a[i] = temp;
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     // @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double[] numbers){

        return recursiveQuick(numbers, 0, numbers.length-1);
    }

    public static double[] recursiveQuick(double[] numbers, int lo, int hi) {
        if(hi <= lo) {
            return numbers;
        }
        int pivotPos = partition(numbers, lo, hi);
        recursiveQuick(numbers, lo, pivotPos-1);
        recursiveQuick(numbers, pivotPos+1, hi);

        return numbers;
    }

    private static int partition(double[] numbers, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        double pivot = numbers[lo];
        while(true) {
            while((numbers[++i] < pivot)) {
                if(i == hi) break;
            }
            while(pivot <= numbers[--j]) {
                if(j == lo) break;
            }
            if(i >= j) break;
            double temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        numbers[lo] = numbers[j];
        numbers[j] = pivot;
        return j;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a : An unsorted array of doubles.
     */






    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double[] a) {

        double [] aux = new double[a.length];
        return mergeSortRecursive(a,aux,0,a.length-1);

    }


    static double[] mergeSortRecursive(double[] a,double[] aux, int lo, int hi){
        if(hi <= lo) return a;

        int mid = lo + (hi-lo)/2;
        mergeSortRecursive(a, aux, lo, mid);
        mergeSortRecursive(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);

        return a;
    }

    static void merge (double[] a, double[] aux, int lo, int mid, int hi) {
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static double[] mergeSortIterative(double[] a) {
        int N = a.length;
        double[] aux = new double[N];
        for (int j = 1; j < N; j = j+j){
            for(int low = 0; low < N - j; low += j + j){
                merge(a, aux,low,low + j - 1, Math.min(low + j + j - 1, N-1));
            }
        }
        return a;
    }


    public static void main(String[] args) {
        File f = new File("numbersNearlyOrdered1000.txt");
        double[] a = new double[1000];

        //insertionSort
        double [] array = Arrays.copyOf(a, a.length);
        long startTime = System.nanoTime();
        SortComparison.insertionSort(array);
        long endTime = System.nanoTime();
        long timePassed = endTime - startTime;
        System.out.println("Insertion sort : " + timePassed / 1000 + " ms");

        //selectionSort()
        double[] array1 = Arrays.copyOf(a, a.length);
        long startTime1 = System.nanoTime();
        SortComparison.selectionSort(array1);
        long endTime1 = System.nanoTime();
        long timePassed1 = endTime1 - startTime1;
        System.out.println("selection sort : " + timePassed1 / 1000 + " ms");

        //mergeSortRecursive()
        double[] array2 = Arrays.copyOf(a, a.length);
        long startTime2 = System.nanoTime();
        SortComparison.mergeSortRecursive(array2);
        long endTime2 = System.nanoTime();
        long timePassed2 = endTime2 - startTime2;
        System.out.println("merge sort Recursive : " + timePassed2 / 1000 + " ms");

        //mergeSortIterative()
        double[] array3 = Arrays.copyOf(a, a.length);
        long startTime3 = System.nanoTime();
        SortComparison.mergeSortIterative(array3);
        long endTime3 = System.nanoTime();
        long timePassed3 = endTime3 - startTime3;
        System.out.println("merge sort Iterative : " + timePassed3 / 1000 + " ms");


        //QuickSort
        double[] array4 = Arrays.copyOf(a, a.length);
        long startTime4 = System.nanoTime();
        SortComparison.quickSort(array4);
        long endTime4 = System.nanoTime();
        long timePassed4 = endTime4 - startTime4;
        System.out.println("quick sort : " + timePassed4 / 1000 + " ms");
    }

}//end class


