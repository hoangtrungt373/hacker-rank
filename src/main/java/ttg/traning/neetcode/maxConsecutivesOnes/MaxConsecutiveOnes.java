package ttg.traning.neetcode.maxConsecutivesOnes;

/**
 *
 * @author ttg
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        // Robustness outside LeetCode constraints: the direct nums[0] access can throw if callers pass null or empty arrays.
        int count = 0;
        int maxCount = 0;
        if (nums[0] == 1) {
            count++;
            maxCount++;
        }
        // Readability: handling index 0 separately makes the flow a bit harder to follow.
        // A single loop from start is simpler and avoids special-case setup.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }

    public int findMaxConsecutiveOnesV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int current = 0;
        int best = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
                best = Math.max(best, current);
            } else {
                current = 0;
            }
        }
        return best;
    }

    public int findMaxConsecutiveOnesV3(int[] nums) {
        int current = 0, best = 0;
        for (int n : nums) {
            current = (n == 1) ? current + 1 : 0;
            if (current > best) best = current;
        }
        return best;
    }
}
