public class Collinear {
// -------------------------------------------------------------------------
    /**
     *  This class contains only two static methods that search for points on the
     *  same line in three arrays of integers.
     *
     *  @author
     *  @version 18/09/18 12:21:09
     */


    // ----------------------------------------------------------

    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     *
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     * <p>
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     * <p>
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * <p>
     * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0
     * <p>
     * In our case y1=1, y2=2, y3=3.
     * <p>
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     * <p>
     * ----------------------------------------------------------
     * <p>
     * <p>
     * Order of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * Order of growth: N^3
     * <p>
     * Explanation: 3 linear for loops
     */

    static int countCollinear(int[] a1, int[] a2, int[] a3) {
        int count = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                for (int k = 0; k < a3.length; k++) {
                    if ((a1[i] * (2 - 3)) + ((a2[j] * (3 - 1))) + (a3[k] * (1 - 2)) == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }



    // ----------------------------------------------------------

    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     *
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     * <p>
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     * <p>
     * <p>
     * Order of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * Order of Growth: N^2 log N
     * <p>
     * Explanation: N^2 for 2 linear for loops, n^2 for insertion sort and N^2 log N for binary search. ignoring
     * lowest order terms and taking highest we get (N^2 log N)
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
        sort(a3);
        int count = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                int array = -1*(a1[i]) + 2*a2[j];
                    if (binarySearch(a3, array)) {
                        count++;
                    }

                }
            }
            return count;
        }


    // ----------------------------------------------------------

    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     *
     * @param a: An UNSORTED array of integers.
     * @return after the method returns, the array must be in ascending sorted order.
     * <p>
     * ----------------------------------------------------------
     * <p>
     * Order of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * Order of Growth: N^2
     * <p>
     * Explanation: Two linear for-loops.
     */
    static void sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int i = j - 1;
            while (i >= 0 && a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                i--;
            }
        }
    }

    // ----------------------------------------------------------

    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     *
     * @param a : A array of integers SORTED in ascending order.
     * @param x : An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     * <p>
     * ----------------------------------------------------------
     * <p>
     * Order of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * Order of Growth: theta(log N)
     *
     * <p>
     * Explanation: while loop = theta(log N) + all constant time theta(1) executions. taking the highest order time we get
     * theta(log N)
     */
    static boolean binarySearch(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x < a[mid]) {
                hi = mid - 1;
            } else if (x > a[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
            return false;
        }
}




