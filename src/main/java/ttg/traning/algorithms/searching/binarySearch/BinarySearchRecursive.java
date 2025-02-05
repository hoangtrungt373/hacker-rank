package ttg.traning.algorithms.searching.binarySearch;

/**
 *
 * @author ttg
 */
public class BinarySearchRecursive {
    // Recursive Binary Search function
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1; // Base case: Not found

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid; // Found
        else if (arr[mid] < target) return binarySearch(arr, mid + 1, right, target); // Right half
        else return binarySearch(arr, left, mid - 1, target); // Left half
    }

    public static void main(String[] args) {
        int[] arr = {3, 11, 12, 22, 25, 50, 64, 90};
        int target = 11;
        int result = binarySearch(arr, 0, arr.length - 1, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}