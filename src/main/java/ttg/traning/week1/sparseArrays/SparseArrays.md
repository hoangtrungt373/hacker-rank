# SparseArrays

There is a collection of input strings and a collection of query strings. 
For each query string, determine how many times it occurs in the list of input 
strings. Return an array of the results.

## Example

_strings = ['aba', 'baba', 'aba', 'xzxb']_

_queries = ['aba', 'xzxb', 'ab']_

There are 2 instances of _'aba'_, 1 of _'xzxb'_ and 0 of _'ab'_. 
For each query, add an element to the return array, _results = [2, 1, 0]_

## Function Description

The function must return an array of integers representing the frequency of 
occurrence of each query string in strings.

**matchingStrings** has the following parameters:

* string strings[n] - an array of strings to search
* string queries[q] - an array of query strings

## Returns

* int[q]: an array of results for each query
