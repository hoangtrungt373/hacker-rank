# Between Two Sets

There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
1. The elements of the first array are all factors of the integer being considered
2. The integer being considered is a factor of all elements of the second array

There number are referred to as being between the two arrays. Determine how many such numbers exists

## Example

    Ex 1
    a = [2, 6]
    b = [24, 36]
    There are two numbers between the arrays: 6 and 12
    6 % 2 = 0, 6 % 6 = 0 and 24 % 6 = 0 36 % 6 = 0 for the first value.
    12 % 2 = 0, 12 % 6 = 0 and 24 % 12 = 0, 36 % 12 = 0 for the second value. Return 2

    Ex 2
    a = [2, 4]
    b = [16, 32, 96]
    2 and 4 divide evenly into 4, 8, 12 and 16
    4, 8 and 16 divide evenly into 16, 32, 96
    4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b. Return 3

## Function Description

**betweenTwoSets** has the following parameter(s):

* int a[n]: an array of integers
* int b[m]: an array of integers

## Returns
* int: the number of integers that are between the sets
