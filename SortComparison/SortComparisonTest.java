import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author ahmed mahdi
 *  @version HT 2022
 */


/*
Microseconds

                               insertionSort            selectionSort         MergeSortRecursive       MergeSortIterative      QuickSort
numbers1000.txt                 8363.3                  14489                 932.3                    478.3                   8744.3
numbers1000 duplicates          8999.3                  11202.3               952.3                    361.3                   8419.3
numbers10000.txt                44915.3                 36820                 2697.6                   1922.3                  78384
numbersNearlyOrdered1000.txt    6590.3                  8595                  699                      257.6                   6798.3
numbersReversed1000.txt         8639                    6802                  2184                     813                     6506
numbersSorted1000.txt           7442.3                  8566.3                715.6                    265                     8143

a. Which of these sorting algorithms does the order of input have an impact on? Why?
b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
d. Did you observe any difference between iterative and recursive implementations of merge
sort?
e. Which algorithm is the fastest for each of the 7 input files?


a. insertion sort because because if it is not in its supposed position or further away from its normal position the more compares needed will be more.
b. selection sort because as the input increases the performance decreases
c. i think merge sort iterative has the best scalability and selectionSort has the worst scalability
d. yes, that the iterative implementation is a lot faster at handling the inputs
e. mergeSortIterative has the fastest time for all of the 6 input files


 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        double[] array = new double[0];
        // testing all sorts with an empty array
        assertEquals( array, SortComparison.selectionSort(array));
        assertEquals( array, SortComparison.insertionSort(array));
        assertEquals(array, SortComparison.mergeSortRecursive(array));
        assertEquals(array, SortComparison.quickSort(array));

    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    @Test
    public void quickSort(){
        double[] sortedArray = { 10.0, 45.5, 50.6, 65.9, 70.8, 79.5, 21.9 };
        assertEquals("Check if quick sort works for a sorted array", "[10.0, 21.9, 45.5, 50.6, 65.9, 70.8, 79.5]",
                Arrays.toString(SortComparison.quickSort(sortedArray)));

        double[] unsortedArray = { 100.56, 29.0, 2.5, 70.8, 90.1, 79.6, 3.7, 50.7 };
        assertEquals("Check if quick sort works for an unsorted array", "[2.5, 3.7, 29.0, 50.7, 70.8, 79.6, 90.1, 100.56]",
                Arrays.toString(SortComparison.quickSort(unsortedArray)));

        double[] oneElementArray = { 16.7 };
        assertEquals("Check if quick sort works for a oneElementArray", "[16.7]",
                Arrays.toString(SortComparison.quickSort(oneElementArray)));

        double[] twoElementArray = { 16.7 , 3.9};
        assertEquals("Check if quick sort works for a oneElementArray", "[3.9, 16.7]",
                Arrays.toString(SortComparison.quickSort(twoElementArray)));


    }

    @Test
    public void selectionSort(){
        double[] sortedArray = { 10.0,45.5,50.6,65.9,70.8 };
        assertEquals("Check if selection sort works for a sorted array", "[10.0, 45.5, 50.6, 65.9, 70.8]",
                Arrays.toString(SortComparison.selectionSort(sortedArray)));

        double[] unsortedArray = { 100.56, 29.0, 2.5, 70.8, 90.1 };
        assertEquals("Check if selection sort works for an unsorted array", "[2.5, 29.0, 70.8, 90.1, 100.56]",
                Arrays.toString(SortComparison.selectionSort(unsortedArray)));

        double[] oneElementArray = { 16.7 };
        assertEquals("Check if selection sort works for a oneElementArray", "[16.7]",
                Arrays.toString(SortComparison.selectionSort(oneElementArray)));

    }

    @Test
    public void insertionSort(){
        double[] sortedArray = { 10.0,45.5,50.6,65.9,70.8 };
        assertEquals("Check if insertion sort works for a sorted array", "[10.0, 45.5, 50.6, 65.9, 70.8]",
                Arrays.toString(SortComparison.insertionSort(sortedArray)));

        double[] unsortedArray = { 100.56, 29.0, 2.5, 70.8, 90.1 };
        assertEquals("Check if insertion sort works for an unsorted array", "[2.5, 29.0, 70.8, 90.1, 100.56]",
                Arrays.toString(SortComparison.insertionSort(unsortedArray)));

        double[] oneElementArray = { 16.7 };
        assertEquals("Check if insertion sort works for a oneElementArray", "[16.7]",
                Arrays.toString(SortComparison.insertionSort(oneElementArray)));

    }

    @Test
    public void mergeSortRecursive(){
        double[] sortedArray = { 10.0,45.5,50.6,65.9,70.8 };
        assertEquals("Check if merge sort works for a sorted array", "[10.0, 45.5, 50.6, 65.9, 70.8]",
                Arrays.toString(SortComparison.mergeSortRecursive(sortedArray)));

        double[] unsortedArray = { 100.56, 29.0, 2.5, 70.8, 90.1 };
        assertEquals("Check if merge sort works for an unsorted array", "[2.5, 29.0, 70.8, 90.1, 100.56]",
                Arrays.toString(SortComparison.mergeSortRecursive(unsortedArray)));

        double[] oneElementArray = { 16.7 };
        assertEquals("Check if merge sort works for a oneElementArray", "[16.7]",
                Arrays.toString(SortComparison.mergeSortRecursive(oneElementArray)));

    }

    @Test
    public void mergeSortIterative(){
        double[] sortedArray = { 10.0,45.5,50.6,65.9,70.8 };
        assertEquals("Check if merge sort works for a sorted array", "[10.0, 45.5, 50.6, 65.9, 70.8]",
                Arrays.toString(SortComparison.mergeSortIterative(sortedArray)));

        double[] unsortedArray = { 100.56, 29.0, 2.5, 70.8, 90.1 };
        assertEquals("Check if merge sort works for an unsorted array", "[2.5, 29.0, 70.8, 90.1, 100.56]",
                Arrays.toString(SortComparison.mergeSortIterative(unsortedArray)));

        double[] oneElementArray = { 16.7 };
        assertEquals("Check if merge sort works for a oneElementArray", "[16.7]",
                Arrays.toString(SortComparison.mergeSortIterative(oneElementArray)));
    }




    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    /*public static void main(String[] args)
    {

    }*/

}

