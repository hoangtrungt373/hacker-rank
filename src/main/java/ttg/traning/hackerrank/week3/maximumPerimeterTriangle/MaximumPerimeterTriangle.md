# MigratoryBirds

Given an array of stick lengths, use 3 of them to construct a non-degenerate triangle with the maximum possible perimeter. 
Return an array of the lengths of its sides as  integers in non-decreasing order.

If there are several valid triangles having the maximum perimeter:
1. Choose the one with the longest maximum side.
2. If more than one has that maximum, choose from them the one with the longest minimum side.
3. If more than one has that maximum as well, print any one them.

If no non-degenerate triangle exists, return .

## Example

    Ex 1
    sticks = [1, 2, 3, 4, 5, 10]
    There are 2 possible unique triangles: (2, 3, 4), (3, 4, 5) -> The longer perimeter is 3 + 4 + 5 = 12.

    Ex 2
    sticks = [1 1 1 3 3]
    There are 2 possible unique triangles: (1, 1, 1), (1, 3, 3) -> The longer perimeter is 1 + 3 + 3 = 7

## Function Description

**maximumPerimeterTriangle** has the following parameter(s):

* int sticks[n]: the lengths of sticks available

## Returns
* int[3] or int[1]: the side lengths of the chosen triangle in non-decreasing order or -1
