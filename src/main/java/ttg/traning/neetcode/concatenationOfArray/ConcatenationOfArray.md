# Concatenation of Array

You are given an integer array `nums` of length `n`. Create an array `ans` of length `2n` where:

- `ans[i] == nums[i]`
- `ans[i + n] == nums[i]`

for `0 <= i < n` (0-indexed).

Return the array `ans`.

## Examples

1. Input: `nums = [1,4,1,2]`  
   Output: `[1,4,1,2,1,4,1,2]`

2. Input: `nums = [22,21,20,1]`  
   Output: `[22,21,20,1,22,21,20,1]`

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 1000`

## Idea

Allocate a new array of size `2n`.  
For each index `i` in the original array, write the value twice:

- once at position `i`
- once at position `i + n`

This directly matches the problem definition.

## Pseudocode

```text
n = length(nums)
ans = new array of size 2n

for i in [0..n-1]:
    ans[i] = nums[i]
    ans[i + n] = nums[i]

return ans
```

## Why this works

For each `i`:

- `ans[i]` is set to `nums[i]`
- `ans[i + n]` is also set to `nums[i]`

So the output is exactly `nums` followed by `nums`, i.e. the concatenation of two `nums` arrays.

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(n)` (the output array of size `2n`)

## Java Reference

```java
public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n * 2];
    for (int i = 0; i < n; i++) {
        ans[i] = nums[i];
        ans[i + n] = nums[i];
    }
    return ans;
}
```
