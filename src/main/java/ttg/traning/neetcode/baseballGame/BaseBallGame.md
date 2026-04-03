# Baseball Game

You are keeping scores for a baseball game. Start with an empty record.

Given a list of strings `operations`, apply each operation in order. Each `operations[i]` is one of:

- An integer `x` (as a string): record a new score of `x`
- `"+"`: record a new score equal to the **sum of the previous two** scores
- `"D"`: record a new score equal to **double** the previous score
- `"C"`: **invalidate** the previous score (remove it from the record)

Return the **sum** of all scores on the record after all operations.

## Examples

1. Input: `ops = ["1","2","+","C","5","D"]`  
   Output: `18`

2. Input: `ops = ["5","D","+","C"]`  
   Output: `15`

## Constraints

- `1 <= operations.length <= 1000`
- Each operation is `"C"`, `"D"`, `"+"`, or a string integer in `(-30000, 30000)`
- For `"+"`, there are always at least two previous scores
- For `"C"` and `"D"`, there is always at least one previous score
- Intermediate values fit in a 32-bit signed integer

## Idea

Treat the record as a **stack** (last score is always the most recent):

- **Number:** push the parsed value
- **`D`:** push `2 * peek()`
- **`C`:** `pop()` to remove the last score
- **`+`:** `pop` twice to get the last two scores (top = most recent), compute their sum, push the second, then the first, then the sum so the history matches the problem’s “previous two” semantics

Then sum all values remaining on the stack (or maintain a running total while processing).

## Pseudocode

```text
stack = empty

for each op in operations:
    if op is "+":
        a = pop()
        b = pop()
        s = a + b
        push(b); push(a); push(s)
    else if op is "C":
        pop()
    else if op is "D":
        push(2 * peek())
    else:
        push(parseInt(op))

return sum of all values in stack
```

## Alternative implementations

- **`Deque` + `ArrayDeque`:** Prefer over `java.util.Stack` for a LIFO structure in modern Java.
- **Running total:** Update an `int total` on every push/pop so you can return `total` without a final traversal (see `calPointsV2` in code).
- **Primitive array + index:** With `operations.length <= 1000`, an `int[]` and `top` index avoids boxing (see `calPointsV3` in code).

## Complexity

- Time: `O(n)` where `n = operations.length`
- Space: `O(n)` for the stack (at most one push per operation in typical flows)

## Java reference (stack + final sum)

```java
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
            case "C" -> scores.pop();
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
```
