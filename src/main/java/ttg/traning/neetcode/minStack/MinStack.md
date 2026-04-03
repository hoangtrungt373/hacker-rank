# Min Stack

Design a stack that supports:

- `MinStack()` — create an empty stack
- `void push(int val)` — push `val`
- `void pop()` — remove the top element
- `int top()` — return the top element
- `int getMin()` — return the **minimum** among all elements currently in the stack

All operations should run in **constant time** on average.

## Example

```text
MinStack minStack = new MinStack();
minStack.push(1);
minStack.push(2);
minStack.push(0);
minStack.getMin(); // 0
minStack.pop();
minStack.top();    // 2
minStack.getMin(); // 1
```

## Constraints

- `-2^31 <= val <= 2^31 - 1`
- `pop`, `top`, and `getMin` are only called when the stack is non-empty

## Idea (Auxiliary “min so far” stack)

Keep two parallel structures with the **same height**:

1. **`arr`** — the actual stack (top is the last element).
2. **`minArr`** — at each level, store the **minimum of all values from the bottom of the stack up to that level** (running minimum for the current depth).

On **push**:

- If the stack was empty, the minimum is `val`.
- Otherwise, the new minimum is `min(previousMinimum, val)`.

Append that value to `minArr`, then append `val` to `arr`.

On **pop**:

- Remove the last element from **both** `arr` and `minArr`.

Then:

- **`top()`** is the last element of `arr`.
- **`getMin()`** is the last element of `minArr` (the minimum over the whole current stack).

## Pseudocode

```text
arr = empty list
minArr = empty list

push(val):
    if arr is empty:
        minArr.append(val)
    else:
        minArr.append(min(minArr.last, val))
    arr.append(val)

pop():
    remove last from arr
    remove last from minArr

top():
    return arr.last

getMin():
    return minArr.last
```

## Alternative approaches (same complexity class)

- **Single stack with pairs** — each entry stores `(value, minUpToHere)` instead of two lists.
- **One stack + one min-only stack** — push onto `minStack` only when `val <= minStack.peek()`; on pop, pop min stack when popping the current minimum (handles duplicates with care).

## Complexity

| Operation | Time (typical) | Extra space |
|-----------|----------------|-------------|
| `push`    | `O(1)` amortized | `O(1)` per push |
| `pop`     | `O(1)`         | |
| `top`     | `O(1)`         | |
| `getMin`  | `O(1)`         | |

Overall extra space: **`O(n)`** for `minArr` alongside `arr`.

## Java reference (two parallel lists)

```java
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
```
