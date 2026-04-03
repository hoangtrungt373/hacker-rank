package ttg.traning.neetcode.validParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author ttg
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        Stack<String> stack = new Stack<>();

        if (s.length() == 1) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));

            boolean isCloseBracket = map.containsKey(ch);
            if (isCloseBracket) {
                if (stack.isEmpty()) {
                    return false;
                }
                String last = stack.peek();
                if (map.get(ch).equals(last)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidV2(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            }
            if (st.isEmpty()) return false;
            char o = st.pop();
            if (c == ')' && o != '(') return false;
            if (c == ']' && o != '[') return false;
            if (c == '}' && o != '{') return false;
        }
        return st.isEmpty();
    }

    public boolean isValidV3(String s) {
        HashMap<Character,Character>map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{

                if(map.keySet().contains(c)){
                    if(stack.peek()==map.get(c)){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
