package ttg.traning.algorithms.searching.binarySearch;

/**
 *
 * @author ttg
 */
public class BinarySearch {
    // Iterative Binary Search function
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (arr[mid] == target) {
                return mid; // Found the target
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 11, 12, 22, 25, 50, 64, 90}; // Must be sorted
        int target = 64;
        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}