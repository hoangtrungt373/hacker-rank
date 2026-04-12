# Sort Colors (Dutch National Flag)

You are given an array `nums` of length `n`, where each element is `0`, `1`, or `2` (often described as **red**, **white**, and **blue**). Sort the array **in-place** so that all `0`s come first, then all `1`s, then all `2`s.

You must **not** use library sorting (e.g. `Arrays.sort`, `Collections.sort`) as the solution.

## Examples

1. `nums = [1, 0, 1, 2]` → `[0, 1, 1, 2]`

2. `nums = [2, 1, 0]` → `[0, 1, 2]`

## Constraints (typical)

- `1 <= nums.length <= 300` (problem-dependent; some variants use up to `10^5`)
- `nums[i]` is `0`, `1`, or `2`

## Follow-up

Solve in **one pass** with **constant extra space** (beyond a few integer variables / small fixed arrays).

---

## Why not general sort?

General comparison sort is `O(n log n)`. Here values are **only three symbols**, so you can achieve **`O(n)`** time and **`O(1)`** extra space with counting or partitioning.

---

## Approach overview

| Approach | Passes | Time | Extra space | Notes |
|----------|--------|------|-------------|--------|
| **Counting sort** (`sortColorsV2`) | 2 | `O(n)` | `O(1)` (array of size 3) | Count `0/1/2`, then overwrite `nums` in order |
| **Dutch national flag** (`sortColorsV3`) | 1 | `O(n)` | `O(1)` | Three pointers: expand `0` from left, `2` from right, scan with `i` |

Both satisfy **no library sort**. The three-pointer variant matches the follow-up.

---

## Counting sort (two passes)

1. **Count:** `count[c]` = how many times color `c` appears (`c ∈ {0,1,2}`).
2. **Fill:** Write `count[0]` zeros, then `count[1]` ones, then `count[2]` twos into `nums` from the start.

**Idea in code (conceptual):**

```text
count[0..2] = 0
for x in nums: count[x]++
index = 0
for c in 0..2:
    repeat count[c] times: nums[index++] = c
```

---

## Dutch national flag (one pass)

Maintain:

- `l` — next position that should get a `0` (grow from the left),
- `r` — next position that should get a `2` (shrink from the right),
- `i` — current element under inspection.

Invariant (typical setup): indices `< l` are `0`, indices `> r` are `2`, and `[l, i)` is “middle” (`1`s).

**Sketch:**

```text
i = 0, l = 0, r = n - 1
while i <= r:
    if nums[i] == 0: swap(nums, l, i); l++; i++
    else if nums[i] == 2: swap(nums, i, r); r--;  // do not i++ yet — new nums[i] unseen
    else: i++   // nums[i] == 1
```

Exact pointer updates match your implementation (`sortColorsV3`): when swapping a `2` to the end, **only** `r` and optionally `i` move so the value pulled to `i` is examined again.

---

## Complexity

| Variant | Time | Extra space |
|---------|------|-------------|
| Counting | `O(n)` | `O(1)` |
| Three-pointer | `O(n)` | `O(1)` |

---

## References

- [LeetCode 75. Sort Colors](https://leetcode.com/problems/sort-colors/)
- E. W. Dijkstra, *A Discipline of Programming* — Dutch National Flag problem
