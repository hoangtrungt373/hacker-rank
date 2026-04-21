# Two Sum

Given an integer array `nums` and an integer `target`, return **two distinct indices** `i` and `j` such that:

`nums[i] + nums[j] == target`

Return the pair with the **smaller index first** (`i < j`).

You may assume **exactly one** valid pair exists.

## Examples

1. Input: `nums = [3, 4, 5, 6]`, `target = 7`  
   Output: `[0, 1]`  
   Explanation: `nums[0] + nums[1] == 7`.

2. Input: `nums = [4, 5, 6]`, `target = 10`  
   Output: `[0, 2]`

3. Input: `nums = [5, 5]`, `target = 10`  
   Output: `[0, 1]`

## Constraints

- `2 <= nums.length <= 1000`
- Values and `target` fit in typical 32-bit signed integer ranges for practice problems
- Exactly one valid answer exists

## Idea (hash map: complement → index)

Scan `nums` **once** from left to right. For each index `i` and value `x = nums[i]`, the partner value you need is `need = target - x`.

- If `need` was **already seen**, you have indices `(indexOf(need), i)` with the smaller index first.
- Otherwise, record that you have seen `x` at `i` (typically by storing **`target - x` → `i`** or **`x` → `i`** depending on formulation).

**Duplicates:** If the same value appears twice (e.g. `[5, 5]` with `target = 10`), keep the **first** occurrence’s index in the map so the second occurrence can pair with it.

## Pseudocode

```text
map = empty hash map  // complement -> index (or value -> index)

for i from 0 to nums.length - 1:
    x = nums[i]
    need = target - x
    if need is in map as a key (meaning we stored earlier info to find partner):
        return [map[need], i]   // exact formulation depends on what you store
    record x at i for future lookups

// (Problem guarantees one solution; otherwise handle “not found”.)
```

Canonical one-pass version: store **`complement → index`**: for each `i`, if `nums[i]` exists as a key in the map, the partner index is `map.get(nums[i])`; else `put(target - nums[i], i)`.

## Alternative approaches

| Approach | Time | Extra space | Notes |
|----------|------|-------------|--------|
| **Hash map** (one pass, complement → index) | `O(n)` average | `O(n)` | Standard; handles duplicates by storing first index |
| Nested loops | `O(n²)` | `O(1)` | Simple, too slow for large `n` |
| Sort + two pointers | `O(n log n)` | `O(n)` if copying pairs | Original indices need care (sort index/value pairs) |

## Complexity (hash map)

- **Time:** `O(n)` average (one pass; map ops `O(1)` average)
- **Space:** `O(n)` for the map

## Java reference

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> indexByComplement = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int x = nums[i];
        if (indexByComplement.containsKey(x)) {
            return new int[] { indexByComplement.get(x), i };
        }
        indexByComplement.put(target - x, i);
    }
    throw new IllegalArgumentException("no solution");
}
```

Here `indexByComplement` maps **`target - nums[j]` → `j`**: when you later see `x = nums[i]`, if `x` was stored as a complement from an earlier `j`, you recover `j` and return `[j, i]`.
