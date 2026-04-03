package ttg.traning.neetcode.minStack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ttg
 */
public class MinStack {

    List<Integer> arr;
    List<Integer> minArr;

    public MinStack() {
        arr = new ArrayList<>();
        minArr = new ArrayList<>();
    }

    public void push(int val) {
        if (arr.isEmpty()) {
            minArr.add(val);
        } else {
            int lastMin = minArr.get(minArr.size() - 1);
            minArr.add(Math.min(lastMin, val));
        }
        arr.add(val);
    }

    public void pop() {
        arr.remove(arr.size() - 1);
        minArr.remove(minArr.size() - 1);
    }

    public int top() {
        return arr.get(arr.size() - 1);
    }

    public int getMin() {
        return minArr.get(minArr.size() - 1);
    }
}
