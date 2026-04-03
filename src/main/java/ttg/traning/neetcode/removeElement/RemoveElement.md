# Remove Element

You are given an integer array `nums` and an integer `val`. Remove all occurrences of `val` **in-place**.

Return the number of remaining elements `k`, such that:

- The first `k` elements of `nums` do **not** contain `val`
- The order of the first `k` elements does **not** matter
- Elements beyond index `k - 1` do not matter

## Examples

1. Input: `nums = [1,1,2,3,4]`, `val = 1`  
   Output: `k = 3`, first `k` elements are some permutation of `[2,3,4]`

2. Input: `nums = [0,1,2,2,3,0,4,2]`, `val = 2`  
   Output: `k = 5`, first `k` elements are some permutation of `[0,1,3,0,4]`

## Constraints

- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

## Idea (Two Pointer / Write Index)

Maintain an index `k` that points to where the next kept element should be written.

- Scan the array from left to right
- If `nums[i] != val`, write it into `nums[k]` and increment `k`
- If `nums[i] == val`, skip it

At the end, `k` is the number of kept elements, and the first `k` positions contain only values not equal to `val`.

## Pseudocode

```text
k = 0
for i in [0..n-1]:
    if nums[i] != val:
        nums[k] = nums[i]
        k = k + 1
return k
```

## Why this works

- Every element not equal to `val` is copied forward exactly once.
- `k` always equals the number of valid (non-`val`) elements written so far.
- The prefix `[0 .. k-1]` is always valid, and by the end it contains all kept elements.

The elements after `k` can be anything, because the problem statement explicitly ignores them.

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(1)`

## Java Reference

```java
public int removeElement(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
```
