# Max Consecutive Ones

Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

## Examples

1. Input: `nums = [1,1,0,1,1,1]`  
   Output: `3`

2. Input: `nums = [1,0,1,1,0,1]`  
   Output: `2`

## Constraints

- `1 <= nums.length <= 100000`
- `nums[i]` is either `0` or `1`

## Idea

Use a single pass with two counters:

- `current`: current streak of consecutive `1`s
- `best`: maximum streak seen so far

When the value is `1`, increase `current` and update `best`.  
When the value is `0`, reset `current` to `0`.

## Pseudocode

```text
current = 0
best = 0

for each value in nums:
    if value == 1:
        current = current + 1
        best = max(best, current)
    else:
        current = 0

return best
```

## Why this works

- Every consecutive block of `1`s is counted exactly once.
- `current` always represents the length of the ongoing block.
- `best` stores the largest block length encountered.

So after iterating through the array, `best` is the answer.

## Complexity

- Time Complexity: `O(n)` where `n` is `nums.length`
- Space Complexity: `O(1)`

## Java Reference

```java
public int findMaxConsecutiveOnes(int[] nums) {
    int current = 0;
    int best = 0;

    for (int n : nums) {
        if (n == 1) {
            current++;
            best = Math.max(best, current);
        } else {
            current = 0;
        }
    }
    return best;
}
```
