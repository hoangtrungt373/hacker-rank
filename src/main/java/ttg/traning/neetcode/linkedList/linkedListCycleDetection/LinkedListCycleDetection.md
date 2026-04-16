# Linked List Cycle Detection

Given the head of a singly linked list, return `true` if the list contains a **cycle**, otherwise return `false`.

A cycle exists if, by repeatedly following `next`, you can reach a node you have visited before.

Internally, some platforms describe the cycle by an `index` (the node the tail points to). You **do not** receive `index` as input — you only get `head`.

## Examples

1. Input: `head = [1,2,3,4]`, `index = 1`  
   Output: `true`  
   Explanation: tail points to node with value `2` (0-indexed position 1).

2. Input: `head = [1,2]`, `index = -1`  
   Output: `false`

## Constraints

- `0 <= length <= 1000`
- `-1000 <= Node.val <= 1000`
- `index` is `-1` or a valid index (conceptual, not provided)

---

## Recommended idea: Floyd’s Tortoise and Hare (two pointers)

Use two pointers starting at the head:

- `slow` moves **1 step** at a time
- `fast` moves **2 steps** at a time

If there is a cycle, `fast` will eventually “lap” `slow` and they will point to the **same node**.
If there is no cycle, `fast` (or `fast.next`) will become `null`.

### Pseudocode

```text
slow = head
fast = head

while fast != null and fast.next != null:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
        return true

return false
```

### Why it works (intuition)

- Without a cycle, `fast` reaches the end first.
- With a cycle, both pointers enter the cycle; once inside, the distance between them shrinks modulo the cycle length until they meet.

### Complexity

- **Time:** `O(n)`  
- **Space:** `O(1)`

---

## Alternative idea: HashSet of visited nodes

Traverse the list and store each node reference in a `Set`. If you ever see a node twice, there is a cycle.

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Edge cases to think about

- Empty list (`head == null`) → `false`
- Single node with `next == null` → `false`
- Single node with `next == itself` → `true`

---

## Java reference in this project

See `LinkedListCycleDetection.java`. The Floyd implementation is in `hasCycleV3`:

```java
public boolean hasCycleV3(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) return true;
    }
    return false;
}
```

## Tests

Test class: `src/test/java/neetcode/linkedListCycleDetection/LinkedListCycleDetectionTest.java`
