# MigratoryBirds

Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. 
If more than 1 type has been spotted that maximum amount, return the smallest of their ids.

## Example

    Ex 1
    arr = [1, 1, 2, 2, 3]
    There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.

## Function Description

**migratoryBirds** has the following parameter(s):

* int arr[n]: the types of birds sighted

## Returns
* int: the lowest type id of the most frequently sighted birds
