package ttg.traning.hackerrank.week1.findTheMedian;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author ttg
 */
public class FindTheMedian {


    public static double process(List<Integer> arr) {
        Collections.sort(arr);

        int n = arr.size();
        if (n % 2 != 0) {
            return arr.get(n / 2);
        } else {
            return (arr.get(n / 2 - 1) + arr.get(n / 2)) / 2.0;
        }
    }

    public static double process1(List<Integer> arr) {

        int n = arr.size();

        // For odd-sized list, the median is the middle element
        if (n % 2 != 0) {
            return quickSelect(arr, 0, n - 1, n / 2);
        } else {
            // For even-sized list, the median is the average of two middle elements
            int left = quickSelect(arr, 0, n - 1, n / 2 - 1);
            int right = quickSelect(arr, 0, n - 1, n / 2);
            return (left + right) / 2.0;
        }
    }

    // This function finds the k-th smallest element in the array. It partitions the array around a pivot and recursively selects the side
    // where the k-th smallest element resides
    private static int quickSelect(List<Integer> arr, int left, int right, int k) {
        // Partition the array and get the pivot index
        int pivotIndex = partition(arr, left, right);

        // If the pivot index is the same as k, return the pivot element
        if (k == pivotIndex) {
            return arr.get(k);
        } else if (k < pivotIndex) {
            // If k is smaller, recurse on the left partition
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            // If k is larger, recurse on the right partition
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    // Partition the array around a pivot
    private static int partition(List<Integer> arr, int left, int right) {
        int pivot = arr.get(right); // Pivot is chosen as the last element
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr.get(j) < pivot) {
                Collections.swap(arr, i, j);
                i++;
            }
        }

        Collections.swap(arr, i, right); // Swap pivot element to its correct position
        return i;
    }
}
