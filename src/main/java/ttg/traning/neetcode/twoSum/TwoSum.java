package ttg.traning.neetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ttg
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!indexMap.containsKey(n)) {
                indexMap.put(n, i);
            }
            if (map.containsKey(target - n)) {
                ans[0] = indexMap.get(target - n);
                ans[1] = i;
                return ans;
            } else {
                map.put(n, target - n);
            }
        }
        return ans;
    }
}