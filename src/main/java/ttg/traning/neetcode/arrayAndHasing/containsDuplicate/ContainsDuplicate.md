# Contains Duplicate

Given an integer array `nums`, return `true` if **any value appears more than once**, otherwise return `false`.

## Examples

1. Input: `nums = [1, 2, 3, 3]`  
   Output: `true`

2. Input: `nums = [1, 2, 3, 4]`  
   Output: `false`

## Idea (Hash set)

Scan the array once. For each number:

- If it is **already** in a set, you have seen a duplicate → return `true`.
- Otherwise **add** it to the set.

If the loop finishes without finding a duplicate, return `false`.

## Pseudocode

```text
set = empty hash set

for each n in nums:
    if n in set:
        return true
    add n to set

return false
```

You can also rely on `add` returning `false` when the element was already present (depending on language / API).

## Alternative approaches

| Approach | Time | Extra space | Notes |
|----------|------|-------------|--------|
| **Hash set** (this solution) | `O(n)` average | `O(n)` | Standard, early exit on first duplicate |
| Sort then check neighbors | `O(n log n)` | `O(1)` if `nums` may be sorted in place | Different problem constraints if array must stay unchanged |
| Nested loops | `O(n²)` | `O(1)` | Too slow for large `n` |

## Complexity (hash set)

- **Time:** `O(n)` average (each insert / lookup is `O(1)` average)
- **Space:** `O(n)` for the set in the worst case (all distinct)

## Java reference

```java
public boolean hasDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
        if (set.contains(n)) {
            return true;
        }
        set.add(n);
    }
    return false;
}
```

A compact variant using `Set.add`’s return value:

```java
public boolean hasDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
        if (!set.add(n)) {
            return true;
        }
    }
    return false;
}
```
