# Replace Elements With Greatest Element On Right Side

You are given an integer array `arr`.  
Replace every element with the greatest element among the elements to its right, and replace the last element with `-1`.

Return the modified array.

## Examples

1. Input: `arr = [2,4,5,3,1,2]`  
   Output: `[5,5,3,2,2,-1]`

2. Input: `arr = [3,3]`  
   Output: `[3,-1]`

## Constraints

- `1 <= arr.length <= 10000`
- `1 <= arr[i] <= 100000`

## Idea

Traverse the array from right to left while keeping track of the maximum value seen so far on the right side.

- `maxRight` stores the greatest value to the right of the current index
- For each index `i` from `n - 2` down to `0`:
  - Save `arr[i]` in `current`
  - Set `arr[i] = maxRight`
  - Update `maxRight = max(maxRight, current)`
- Set the last element to `-1`

This works in-place with constant extra space.

## Pseudocode

```text
maxRight = arr[n - 1]

for i from n - 2 down to 0:
    current = arr[i]
    arr[i] = maxRight
    maxRight = max(maxRight, current)

arr[n - 1] = -1
return arr
```

## Why this works

- At index `i`, `maxRight` already represents the maximum of all elements strictly to the right.
- Replacing `arr[i]` with `maxRight` is exactly the required operation.
- Updating `maxRight` with the old value of `arr[i]` keeps the invariant valid for the next step to the left.

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(1)`

## Java Reference

```java
public int[] replaceElements(int[] arr) {
    int maxRight = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
        int current = arr[i];
        arr[i] = maxRight;
        maxRight = Math.max(maxRight, current);
    }
    arr[arr.length - 1] = -1;
    return arr;
}
```
