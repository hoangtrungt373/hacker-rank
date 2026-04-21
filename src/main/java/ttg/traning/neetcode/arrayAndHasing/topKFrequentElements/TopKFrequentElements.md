# Top K Frequent Elements

Given an integer array `nums` and an integer `k`, return the **`k` most frequent elements**. Order of the returned values does not need to match any particular tie-breaking rule unless the problem states one.

## Examples (conceptual)

1. `nums = [1,1,1,2,2,3]`, `k = 2` → frequencies: `1` appears 3 times, `2` twice, `3` once → answer could be `[1, 2]` (any order if allowed).

2. `nums = [1]`, `k = 1` → `[1]`.

## Constraints (typical)

- `1 <= nums.length <= 10^5`
- `k` is in range `[1, number of distinct values in nums]`

---

## Approach overview

| Approach | Time | Extra space | Notes |
|----------|------|-------------|--------|
| Count + sort pairs by frequency | `O(n + m log m)` | `O(m)` | `m` = distinct values |
| **Min-heap of size `k`** (`topKFrequentV2`) | `O(n + m log k)` | `O(n + k)` | Good when `k << m` |
| Bucket / frequency array (`topKFrequentV3`) | `O(n)` | `O(n)` | Linear when you can index by frequency |

---

## `PriorityQueue` in Java

`java.util.PriorityQueue<E>` is an **unbounded priority queue** backed by a **binary min-heap** by default (smallest element at the root according to ordering).

- **Custom order:** pass a `Comparator` to the constructor. Your comparator defines which element is “smallest” for heap purposes.

### Common methods

| Method | Meaning |
|--------|---------|
| `offer(e)` | Insert `e`; returns `true` (or fails only on capacity limits, which unbounded queue does not have). Heap is **reordered** so the min-heap property holds — `O(log size)`. |
| `poll()` | Remove and return the **head** (the “first” element by order); returns `null` if empty — `O(log size)`. |
| `peek()` | Return the head without removing — `O(1)`. |

So **`offer` = insert**, **`poll` = remove min** (for default / your comparator’s “minimum”).

---

## `topKFrequentV2`: min-heap of size `k`

**Idea:** Count each value’s frequency with a hash map. Then keep only the **`k` pairs** `(frequency, value)` with the **largest** frequencies by using a **min-heap** ordered by frequency:

- Heap compares `a[0]` vs `b[0]` (frequency). Smaller frequency is at the top.
- If the heap grows beyond `k`, **remove** the smallest frequency — so you always drop the least frequent among the current top candidates.

After processing all distinct values, the heap holds the `k` most frequent elements (ties may be arbitrary depending on comparator stability).

```java
PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
    heap.offer(new int[]{entry.getValue(), entry.getKey()});
    if (heap.size() > k) {
        heap.poll();
    }
}
```

Extract answers by polling the heap `k` times and taking `entry.getKey()` (stored as `[1]` in the `int[]`).

---

## Complexity of `topKFrequentV2`

Let `n = nums.length` and `m =` number of **distinct** values in `nums`.

- **Time**
  - Build counts: **`O(n)`**
  - For each of `m` distinct values: one `offer` and at most one `poll` on a heap of size ≤ `k` → each heap op is **`O(log k)`**
  - Total: **`O(n + m log k)`**
- **Space**
  - Count map: **`O(m)`**
  - Heap: at most **`k`** entries → **`O(k)`**
  - Often summarized as **`O(n + k)`** extra space in discussion (map dominates for distinct keys; both are linear in problem size).

If `k` is large (close to `m`), this is similar to sorting approaches; if `k` is small, the heap avoids sorting all `m` pairs.

---

## Does “maintaining order” in `PriorityQueue` make it `O(n²)`?

**No.** A `PriorityQueue` does **not** keep all elements in fully sorted order internally. It keeps a **heap**: only the **parent–child** ordering property holds (parent ≤ children for a min-heap with natural order). Finding the minimum is `O(1)` at the root; insert/remove is **`O(log size)`**, not linear in `n`.

So for `topKFrequentV2`, each `offer` / `poll` is **`O(log k)`**, not `O(n)` or `O(n²)`. Total remains **`O(n + m log k)`**, not `O(n²)` from the queue alone.

---

## How `PriorityQueue` stores elements (conceptual)

Internally, Java’s `PriorityQueue` uses an **array** representing a **complete binary tree** (heap):

- Index `0` = root (minimum by comparator).
- For node at index `i`: left child at `2*i+1`, right at `2*i+2`, parent at `(i-1)/2`.

**Example:** `PriorityQueue<Integer>` with natural order, after inserting `5, 3, 7, 1`:

After inserts, the heap might be laid out like (array order is tree level-order):

```text
        1
       / \
      3   7
     /
    5

array: [1, 3, 7, 5]
```

The array is **not** sorted as `[1,3,5,7]`; it is **heap-ordered**. Iterating the queue does not guarantee global sorted order; **`poll()`** always returns the current minimum.

For `topKFrequentV2`, each element is `int[]{frequency, value}`; the comparator compares `a[0]` and `b[0]`, so the root is the pair with **smallest frequency** among those in the heap.

---

## Related implementations in this class

- **`topKFrequent`:** count, collect pairs, sort by frequency descending — **`O(n + m log m)`** time.
- **`topKFrequentV3`:** bucket by frequency — **`O(n)`** time, **`O(n)`** space for buckets.

---

## References

- [Java `PriorityQueue` (Oracle)](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html)
