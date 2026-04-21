# Valid Anagram

Given two strings `s` and `t`, return `true` if they are **anagrams** of each other, otherwise `false`.

An anagram uses the **same characters with the same frequencies**; only the order may differ.

## Examples

1. Input: `s = "racecar"`, `t = "carrace"`  
   Output: `true`

2. Input: `s = "jar"`, `t = "jam"`  
   Output: `false`

## Constraints

- `s` and `t` consist of **lowercase English letters** (`a`–`z`).

## Idea (frequency array)

If `s` and `t` have different lengths, they cannot be anagrams.

Otherwise, count how many times each letter appears. For a fixed lowercase alphabet, use an array of size **26**: index `c - 'a'` for each character `c`.

A common one-pass trick when lengths already match:

- For each index `i`, increment for `s.charAt(i)` and decrement for `t.charAt(i)`.
- After the loop, every cell must be **zero** if the multisets are identical.

## Pseudocode

```text
if length(s) != length(t):
    return false

counts = array of 26 zeros

for i from 0 to length(s) - 1:
    counts[s[i] - 'a']++
    counts[t[i] - 'a']--

for each value v in counts:
    if v != 0:
        return false

return true
```

## Alternative approaches

| Approach | Time | Extra space | Notes |
|----------|------|-------------|--------|
| **Frequency array** (`int[26]`) | `O(n)` | `O(1)` | Best fit when alphabet is exactly 26 lowercase letters |
| **Hash map** (`Map<Character, Integer>`) | `O(n)` | `O(k)` for `k` distinct chars | Use when alphabet is large or not fixed |
| **Sort both strings** | `O(n log n)` | `O(n)` or sort stack | Compare sorted char arrays with `Arrays.equals` |
| **Two maps then `equals`** | `O(n)` | `O(k)` | Build count maps for `s` and `t`, then `mapS.equals(mapT)` |

## Complexity (frequency array)

- **Time:** `O(n)` where `n = s.length()`
- **Space:** `O(1)` extra (26 counters is constant)

## Java reference

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counts[s.charAt(i) - 'a']++;
        counts[t.charAt(i) - 'a']--;
    }
    for (int count : counts) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
```

**Sort-based variant** (different complexity, often acceptable in interviews):

```java
public boolean isAnagramBySorting(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] a = s.toCharArray();
    char[] b = t.toCharArray();
    java.util.Arrays.sort(a);
    java.util.Arrays.sort(b);
    return java.util.Arrays.equals(a, b);
}
```
