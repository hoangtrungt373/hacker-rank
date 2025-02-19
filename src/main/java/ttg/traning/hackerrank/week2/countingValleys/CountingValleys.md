# Counting Valleys

An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly steps, 
for every step it was noted if it was an uphill _U_, or a downhill , _D_ step. Hikes always start and end 
at sea level, and each step up or down represents a _1_ unit change in altitude. We define the following terms:

* A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and 
ending with a step down to sea level.
* A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and 
ending with a step up to sea level.

Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.

## Example

Ex 1

    path = [D D U U D D U D U U U D]
    
    visualize:
                _          /\_
                 \  /\    /  
                  \/  \/\/
    
    number of vallerys: 2

Ex 2

    path = [U D D D U D U U]
    
    visualize:
                _/\      _
                   \    /
                    \/\/
    
    number of vallerys: 1


## Function Description

**countingValleys** has the following parameter(s):

* string path: a string describing the path

## Returns

* int: the number of valleys traversed