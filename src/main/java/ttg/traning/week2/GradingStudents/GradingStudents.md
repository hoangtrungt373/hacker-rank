# Grading Students

HackerLand University has the following grading policy:
* Every student receives a _grade_ in the inclusive range from _0_ to _100_.
* Any _grade_ less than _40_ is a failing grade.

Sam is a professor at the university and likes to round each student's  according to these rules:

* If the difference between the _grade_ and the next multiple of _5_ is less than _3_, round _grade_ up to the next multiple of _5_.
* If the value of _grade_ is less than _38_, no rounding occurs as the result will still be a failing grade.

## Example

* _grade_ = _84_ round to _85_ (85 - 84 is less than 3)
* _grade_ = _29_ do not round (result is less than 40)
* _grade_ = _57_ do not round (60 - 57 is 3 or higher)

* Given the initial value of _grade_ for each of Sam's  students, write code to automate the rounding process.

## Function Description

**gradingStudents** has the following parameter(s):

* int grades[n]: the grades before rounding

## Returns

* int[n]: the grades after rounding as appropriate