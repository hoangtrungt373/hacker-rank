# MarsExploration

Given the signal received by Earth as a string _str_
determine how many letters of the SOS message have been changed by radiation.

## Example

    Ex 1
    Str = SOSTOT
    The original message was SOSSOS. 
    We print the number of changed letters, which is 2.

    Ex 2
    Str = SOSSPSSQSSOR
    The original message was SOSSOSSOSSOS. 
    We print the number of changed letters, which is 3.

    

## Function Description

**marsExploration** has the following parameter(s):

* string s: the string as received on Earth

## Returns

* int: the number of letters changed during transmission