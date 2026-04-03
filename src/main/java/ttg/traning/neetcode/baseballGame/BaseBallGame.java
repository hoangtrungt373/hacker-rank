package ttg.traning.neetcode.baseballGame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author ttg
 */
public class BaseBallGame {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        int point = 0;
        for (String ch : operations) {
            switch (ch) {
                case "+" -> {
                    int temp1 = scores.pop();
                    int temp2 = scores.pop();
                    int sum = temp1 + temp2;
                    scores.push(temp2);
                    scores.push(temp1);
                    scores.push(sum);
                }
                case "C" -> {
                    scores.pop();
                }
                case "D" -> {
                    point = scores.peek() * 2;
                    scores.push(point);
                }
                default -> {
                    point = Integer.parseInt(ch);
                    scores.push(point);
                }
            }
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public int calPointsV2(String[] operations) {
        Deque<Integer> st = new ArrayDeque<>();
        int total = 0;
        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    int a = st.pop();
                    int b = st.pop();
                    int s = a + b;
                    st.push(b);
                    st.push(a);
                    st.push(s);
                    total += s;
                }
                case "C" -> {
                    total -= st.pop();
                }
                case "D" -> {
                    int d = st.peek() * 2;
                    st.push(d);
                    total += d;
                }
                default -> {
                    int x = Integer.parseInt(op);
                    st.push(x);
                    total += x;
                }
            }
        }
        return total;
    }

    public int calPointsV3(String[] operations) {
        int[] st = new int[operations.length];
        int top = -1;
        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    int a = st[top--];
                    int b = st[top--];
                    int s = a + b;
                    st[++top] = b;
                    st[++top] = a;
                    st[++top] = s;
                }
                case "C" -> top--;
                case "D" -> {
                    int d = st[top] * 2;
                    st[++top] = d;
                }
                default -> st[++top] = Integer.parseInt(op);
            }
        }
        int sum = 0;
        for (int i = 0; i <= top; i++) sum += st[i];
        return sum;
    }
}
