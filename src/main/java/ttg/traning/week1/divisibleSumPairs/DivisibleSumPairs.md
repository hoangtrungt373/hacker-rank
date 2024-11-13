# DivisibleSumPairs

Given an array of integers and a positive integer _k_, determine the number of _(i, j)_
pairs where _i < j_ and _ar[i] + ar[j]_ is divisible by _k_.

## Example

_ar = [1, 2, 3, 4, 5, 6]_

_k = 5_

Three pairs meet the criteria: _[1, 4]_, _[2, 3]_ and _[4, 6]_

## Function Description

_divisibleSumPairs_ has the following parameter(s):

* int n: the length of array _ar_
* int ar[n]: an array of integers
* int k: the integer divisor

## Returns

* int: the number of pairs