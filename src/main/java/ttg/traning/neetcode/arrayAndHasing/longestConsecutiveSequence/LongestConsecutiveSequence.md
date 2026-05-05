# Longest Consecutive Sequence

Given an unsorted integer array `nums`, return the length of the longest sequence of consecutive integers.

A consecutive sequence means values increase by `1` each step (for example: `1, 2, 3, 4`).

## Example

- Input: `nums = [100, 4, 200, 1, 3, 2]`
- Output: `4`
- Explanation: The longest consecutive sequence is `[1, 2, 3, 4]`

## Idea (Optimal HashSet approach)

Put all numbers into a `HashSet` so membership checks are `O(1)` average.

Then only start counting from numbers that are sequence starts:

- A number `num` is a start if `num - 1` is **not** in the set.
- From each start, keep moving forward (`num + 1`, `num + 2`, ...) while values exist.
- Track the maximum length seen.

This avoids re-counting the same sequence from middle elements.

## Pseudocode

```text
numSet = set(nums)
longest = 0

for each num in numSet:
    if (num - 1) not in numSet:     // sequence start
        length = 1
        while (num + length) in numSet:
            length++
        longest = max(longest, length)

return longest
```

## Why this works

- Every sequence is counted exactly once, from its smallest element.
- Non-start elements are skipped, so we avoid repeated work.
- The longest counted sequence length is the answer.

## Complexity

- Time: `O(n)` average (HashSet operations are average `O(1)`)
- Space: `O(n)` for the set

## Notes about implementations in this class

In `LongestConsecutiveSequence.java`, you currently have multiple variants:

- `longestConsecutive`: set + forward scan from each original element (can do repeated work in worst case)
- `longestConsecutiveV2`: sorting-based approach (`O(n log n)`)
- `longestConsecutiveV3`: optimal HashSet "start-of-sequence" approach (`O(n)` average)
- `longestConsecutiveV4`: boundary/length map union-style approach (`O(n)` average)

For interviews and clarity, `longestConsecutiveV3` is usually the best balance of performance and readability.

## Java reference (V3 style)

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
        numSet.add(num);
    }

    int longest = 0;
    for (int num : numSet) {
        if (!numSet.contains(num - 1)) {
            int length = 1;
            while (numSet.contains(num + length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }
    }
    return longest;
}
```
