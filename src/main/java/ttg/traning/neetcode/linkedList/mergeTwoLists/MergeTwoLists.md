# Merge Two Sorted Lists

You are given the heads of two sorted linked lists, `list1` and `list2`.

Merge them into one sorted linked list and return the head of the merged list.
The merged list should reuse existing nodes from `list1` and `list2` (not create a brand-new value list).

## Examples

1. Input: `list1 = [1,2,4]`, `list2 = [1,3,5]`  
   Output: `[1,1,2,3,4,5]`

2. Input: `list1 = []`, `list2 = [1,2]`  
   Output: `[1,2]`

3. Input: `list1 = []`, `list2 = []`  
   Output: `[]`

## Constraints

- `0 <= length of each list <= 100`
- `-100 <= Node.val <= 100`
- Both lists are already sorted in non-decreasing order

## Idea (two pointers + dummy head)

Use two pointers to walk both lists:

- Compare current nodes from `list1` and `list2`
- Append the smaller node to the merged list
- Move that list’s pointer forward

A `dummy` node is used to simplify linking logic.  
When one list runs out, append the remaining part of the other list directly.

## Pseudocode

```text
dummy = new ListNode(0)
tail = dummy

while list1 != null and list2 != null:
    if list1.val < list2.val:
        tail.next = list1
        list1 = list1.next
    else:
        tail.next = list2
        list2 = list2.next
    tail = tail.next

if list1 != null:
    tail.next = list1
else:
    tail.next = list2

return dummy.next
```

## Why this works

- At each step, the smallest current available value is chosen, so merged order stays sorted.
- Nodes are linked exactly once into the output chain.
- Remaining suffix is already sorted, so it can be attached as-is.

## Complexity

- **Time:** `O(m + n)` where `m` and `n` are the lengths of `list1` and `list2`
- **Space:** `O(1)` extra (ignoring input nodes)

## Edge cases

- Both lists empty -> return `null`
- One list empty -> return the other list directly
- Duplicate values across lists -> all duplicates preserved

## Java reference

Implementation is in `MergeTwoLists.java`:

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;

    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            node.next = list1;
            list1 = list1.next;
        } else {
            node.next = list2;
            list2 = list2.next;
        }
        node = node.next;
    }

    if (list1 != null) {
        node.next = list1;
    } else {
        node.next = list2;
    }

    return dummy.next;
}
```

## Tests

Test class: `src/test/java/neetcode/mergeTwoLists/MergeTwoListsTest.java`
