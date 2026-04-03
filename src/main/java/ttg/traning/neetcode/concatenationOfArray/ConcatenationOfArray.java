package ttg.traning.neetcode.concatenationOfArray;

/**
 *
 * @author ttg
 */
public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public int[] getConcatenationV2(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];

        for(int i =0;i<2*n;i++){
            if(i<n) {
                res[i]=nums[i];
            } else {
                res[i]=nums[i-n];
            }
        }
        return res;
    }
}
