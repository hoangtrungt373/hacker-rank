### 1. PlusMinus

#### 1.1 Calculate Double's DataType
- Java handles floating-point precision directly when dividing double values.
- Ratios are calculated without unnecessary additions to 0.000000
  
=> We don't have to do this: 1.00 + ~~0.000000 (redundant)~~

### 3. TimeConversion
#### 3.1 DateTimeFormatter
- A modern and robust approach to convert time in 12hour AM/PM format to military (24-hour) format
#### 3.2 String.format("%02d", hour)
- Ensure the hour is always formatted as two digits

### 5. DivisibleSumPairs
#### 5.1 HashMap: Time complexity and space complexity

| Operation                       | Time Complexity                                                      | Space Complexity           |
|---------------------------------|----------------------------------------------------------------------|----------------------------|
| get(key)                        | O(1) on average, O(n) in worst case (all keys collide)               | O(n) (for the map storage) |
| put(key, value)                 | O(1) on average, O(n) in worst case (rehashing or all keys collide)  | O(n)                       |
| remove(key)                     | O(1) on average, O(n) in worst case (all keys collide)	              | O(n)                       |
| containsKey(key)                | O(1) on average, O(n) in worst case	O(n)                             | O(n)                       |
| getOrDefault(key, defaultValue) | O(1) on average, O(n) in worst case	                                 | O(n)                       |

### 7. FindTheMedian
#### 7.1 Algorithm QuickSelect
- Finding the k-th Smallest or k-th Largest Element
    + To find the 3rd smallest element: _quickSelect(arr, 0, arr.length - 1, 3);_
    + To find the 3rd largest element: _quickSelect(arr, 0, arr.length - 1, arr.length - 3);_
#### 7.2 Collections.sort()
- Using TimSort Algorithm which is a hybrid sorting algorithm derived from Merge Sort and Insertion Sort
#### 7.3 Insertion Sort vs Merge Sort vs TimSort
| Algorithm      | Time Complexity                    | Space Complexity | Stability | Best Use Cases                     |
|----------------|------------------------------------|------------------|-----------|------------------------------------|
| Insertion Sort | O(n2), O(n) for nearly sorted      | O(1)             | YES       | Small datasets, nearly sorted data |
| Merge Sort     | O(n log n ) always                 | O(n)             | YES       | Large datasets, external sorting   |
| TimSort        | O(n log n), O(n) for nearly sorted | O(n)             | YES       | General-purpose, real-world data   |
