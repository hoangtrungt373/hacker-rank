# FibonacciSequence
The Fibonacci Sequence is a series of numbers where each number is the sum of the two preceding ones, 
usually starting with 0 and 1. The sequence begins:

#### Mathematical Definition
* F(0) = 0
* F(1) = 1
* F(n) = F(n-1) + F(n-2) for n ≥ 2

In other words:

* The 0th Fibonacci number is 0.
* The 1st Fibonacci number is 1.
* The 2nd Fibonacci number is F(2) = F(1) + F(0) = 1 + 0 = 1.
* The 3rd Fibonacci number is F(3) = F(2) + F(1) = 1 + 1 = 2.
* The 4th Fibonacci number is F(4) = F(3) + F(2) = 2 + 1 = 3.
* And so on.

#### Time and Space Complexity

1. Recursive Approach:
* Time Complexity: O(2^n) (due to repeated calculations)
* Space Complexity: O(n) (due to the function call stack)

2. Dynamic Programming Approach (Iterative):
* Time Complexity: O(n)
* Space Complexity: O(n) (storing results of Fibonacci numbers)

#### UseCase
* Dynamic Programming: Fibonacci is a classic problem that demonstrates the power of dynamic programming for optimizing recursive solutions.
* Algorithmic Optimization: Fibonacci sequence often appears in algorithms for problems like finding the nth term in a sequence, 
calculating binomial coefficients, or even graph traversal.
* Cryptography: Some cryptographic algorithms use Fibonacci numbers for generating sequences or for modular arithmetic.
