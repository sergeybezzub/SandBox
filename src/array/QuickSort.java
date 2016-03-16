package array;

import java.util.Arrays;

public class QuickSort{

    public static void main(String args[]) {

        int[] input = { 23, 31, 1, 21, 36, 72};
        System.out.println("Before sorting : " + Arrays.toString(input));
        quickSort(input); // sort the integer array using quick sort algorithm
        System.out.println("After sorting : " + Arrays.toString(input));
     
        // input with duplicates
        int[] withDuplicates = { 11, 14, 16, 12, 11, 15};
        System.out.println("Before sorting : " + Arrays.toString(withDuplicates));
        quickSort(withDuplicates); // sort the integer array using quick sort algorithm
        System.out.println("After sorting : " + Arrays.toString(withDuplicates));
    }

    public static void quickSort(int[] array) {
    	int size =array.length - 1;
        recursiveQuickSort(array, 0, size);
    }

    /**
     * QuickSort
     * @param array
     * @param startIdx
     * @param endIdx
     */
    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
     
        int idx = devideArray(array, startIdx, endIdx);

        // Call quick sort with left part of array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Call quick sort with right part of array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

    /**
     * Divides array from pivot, left side contains elements less than
     * Pivot while right side contains elements greater than pivot.
     *
     * @param array array to partitioned
     * @param left lower bound of the array
     * @param right upper bound of the array
     * @return the partition index
     */
    public static int devideArray(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
}
