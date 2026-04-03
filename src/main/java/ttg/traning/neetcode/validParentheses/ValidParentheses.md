# Valid Parentheses

You are given a string `s` containing only these characters: `'('`, `')'`, `'{'`, `'}'`, `'['`, `']'`.

The string is **valid** if and only if:

1. Every opening bracket is closed by a bracket of the **same type**
2. Opening brackets are closed in the **correct order**
3. Every closing bracket has a **matching** opening bracket of the same type

Return `true` if `s` is valid, otherwise `false`.

## Examples

1. Input: `s = "[]"`  
   Output: `true`

2. Input: `s = "([{}])"`  
   Output: `true`

3. Input: `s = "[(])"`  
   Output: `false` (order is wrong)

## Constraints

- `1 <= s.length <= 1000`

## Idea (Stack)

Scan the string from left to right and keep a **stack** of unmatched opening brackets (the most recent open is on top).

- If you see an **opening** bracket, **push** it.
- If you see a **closing** bracket:
  - If the stack is **empty**, return `false` (nothing to match).
  - Otherwise **pop** the top and check it is the **correct** partner for this closing bracket.
  - If it does not match, return `false`.

After the scan, the string is valid only if the stack is **empty** (no unclosed opens).

A small map (or `switch`) maps each closing bracket to its required opening bracket:

- `)` → `(`
- `]` → `[`
- `}` → `{`

## Pseudocode

```text
stack = empty

for each character c in s:
    if c is an opening bracket:
        push(c)
    else:  // closing bracket
        if stack is empty:
            return false
        if top of stack != matching_open_for(c):
            return false
        pop()

return stack is empty
```

## Alternative style

- Use `Deque<Character>` with `ArrayDeque` instead of `java.util.Stack` (common modern style).
- Use `char` and explicit checks for `(` `[` `{` and the three closers instead of a `HashMap` (often clearer for exactly these three pairs).

## Complexity

- Time: `O(n)` where `n = s.length()`
- Space: `O(n)` for the stack in the worst case (e.g. all opening brackets)

## Java reference (map + stack)

```java
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
```
