package ttg.traning.neetcode.sortColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author ttg
 */
public class SortColor {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        List<Integer> freq = new ArrayList<>();
        for (int n : nums) {
            freq.add(0);
        }
        for (int n : nums) {
            freq.set(n, freq.get(n) + 1);
        }

        int i = 0;
        for (int j = 0; i < freq.size(); j++) {
            for (int k = 0; k < freq.get(j); k++) {
                nums[i] = j;
                i++;
            }
        }
    }

    public void sortColorsV2(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    public void sortColorsV3(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

