# FlippingMatrix

Reverse the columns and rows of the matrix as many times as you want so that the sum 
of the values of the elements of the submatrix in the Upper Left Quadrant position 
is the largest.

## Example
    For the below matrix, perform the following operations to maximize the sum of 
    nxn submatrix in the upper-left quadrant
    [ 112, 42, 83, 119 ],
    [56, 125, 56, 49 ],
    [ 15, 78, 101, 43 ],
    [ 62, 98, 114, 108 ]

    Reverse col 2
    [ 112, 42, 114, 119 ],
    [56, 125, 101, 49 ],
    [ 15, 78, 56, 43 ],
    [ 62, 98, 83, 108 ]

    Reverse row 0
    [ 119, 114, 42, 112],  
    [56, 125, 101, 49 ],
    [ 15, 78, 56, 43 ],
    [ 62, 98, 83, 108 ]

    -> The sum of values in the nxn submatrix in the upper-left quadrant is: 119 + 114 + 56 + 125 = 414

## Function Description

**flippingMatrix** has the following parameter(s):

* matrix[n][n]: the matrix

## Returns

* int: sum of values of sub-matrix satisfying above condition