# Reverse Linked List

Given the head of a **singly linked list**, reverse the list **in place** (by rewiring `next` pointers) and return the **new head** (the old tail, or `null` if the list was empty).

## Examples

1. Input: `head` represents `[0, 1, 2, 3]`  
   Output: list `[3, 2, 1, 0]`

2. Input: `head == null` (empty list)  
   Output: `null`

## Constraints

- `0 <= list length <= 1000`
- `-1000 <= Node.val <= 1000`

## Idea (iterative, three pointers)

Walk the list once. Keep:

- `prev` — the node that will become the **successor** of the current node after reversal (initially `null`)
- `curr` — the node you are processing

For each `curr`:

1. Remember `curr.next` before you overwrite it (often called `temp` / `next`).
2. Point `curr.next` to `prev`.
3. Advance: `prev = curr`, `curr = temp`.

When `curr` becomes `null`, `prev` is the **new head**.

**Why it works:** You never lose the rest of the list because you save `curr.next` before breaking the link. Each step “peels” the front of the unreversed suffix and prepends it to the already-reversed prefix.

## Pseudocode

```text
prev = null
curr = head

while curr is not null:
    temp = curr.next // keep rest of list
    curr.next = prev      // reverse link
    prev = curr
    curr = temp

return prev
```

## Alternative approaches

| Approach | Time | Extra space | Notes |
|----------|------|-------------|--------|
| **Iterative** (above) | `O(n)` | `O(1)` | Standard; easy to get right with `temp` |
| **Recursive** | `O(n)` | `O(n)` stack | Elegant; watch stack depth on long lists |
| Copy values to array, rebuild | `O(n)` | `O(n)` | Avoid for this problem; not in-place |

## Complexity (iterative)

- **Time:** `O(n)` — one pass over `n` nodes  
- **Space:** `O(1)` — only a few pointer variables

## Edge cases

- **Empty list:** `head == null` → return `null` (loop never runs; `prev` stays `null`).
- **Single node:** reversing is a no-op; new head is still that node.
- **Two nodes:** sanity check that you do not drop the second node (always save `next` before rewiring).

## Java reference (iterative)

Implementation lives in `ReverseLinkedList.java`:

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }
    return prev;
}
```

## Tests

JUnit tests: `src/test/java/ttg/traning/neetcode/reverseLinkedList/ReverseLinkedListTest.java`
