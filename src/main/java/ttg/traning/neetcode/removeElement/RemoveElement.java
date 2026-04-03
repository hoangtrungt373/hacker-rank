package ttg.traning.neetcode.removeElement;

/**
 *
 * @author ttg
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        // Low – Time complexity is too high
        // Nested shifting makes worst-case behavior close to O(n^2). This problem has a standard O(n) in-place solution.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int sub = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        sub = j - i;
                        break;
                    }
                }
                for (int k = i; k < nums.length - sub; k++) {
                    nums[k] = nums[k + sub];
                }
                for (int l = nums.length - sub; l < nums.length; l++) {
                    nums[l] = val;
                }
            }
        }
        for (int num : nums) {
            if (num != val) {
                count++;
            }
        }
        return count;
    }

    // Use a write pointer (k) and copy only values not equal to val:
    public int removeElementV2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}