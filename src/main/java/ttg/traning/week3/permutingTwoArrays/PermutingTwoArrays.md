# PermutingTwoArrays

There are two n-element arrays of integers, A and B. 
Permute them into some A' and B' such that the relation A'[i] + B'[i] >= k holds for all i where 0 <= i < n.

## Example

    Ex 1
    A = [0, 1]
    B = [0, 2]
    k = 1
    exists valid A', B' is A' = [1, 0], B' = [0, 2]: 1 + 0 >= 1, 0 + 2 >= 1

    Ex 2
    A = [2, 1, 3]
    B = [7, 8, 9]
    k = 10
    exists valid A', B' is A' = [1, 2, 3], B' = [9, 8, 7]: 1 + 9 >= 10, 2 + 8 >= 10, 3 + 7 >= 10
    
    Ex 3
    A = [1, 2, 2, 1]
    B = [3, 3, 3, 4]
    k = 5
    Not exists valid A', B' since to permute A and B into a valid A' and B', 
    there must be at least three numbers in A that are greater than 1.

## Function Description

**twoArrays** has the following parameter(s):

* int k: an integer
* int A[n]: an array of integers
* int B[n]: an array of integers

## Returns
* boolean: if exists valid A', B'
