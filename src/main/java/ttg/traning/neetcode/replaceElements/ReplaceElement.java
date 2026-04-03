package ttg.traning.neetcode.replaceElements;

/**
 *
 * @author ttg
 */
public class ReplaceElement {

    public int[] replaceElements(int[] arr) {
        int maxRight = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxRight;
            maxRight = Math.max(maxRight, current);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public int[] replaceElementsV2(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int rightMax = -1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }
        return ans;
    }
}
