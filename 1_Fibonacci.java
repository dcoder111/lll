Practical No.1
Aim: Write a program non-recursive and recursive program to calculate Fibonacci numbers and analyze their time and space complexity.

import java.util.Scanner;
public class Fibonacci 
{
    // Recursive approach to calculate the nth Fibonacci number
    static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Sequence print kara mhantle ki Un commemnt kra.following code
    
    // Function to print Fibonacci sequence using recursion
    // static void printFibonacciRecursive(int n) {
    //     System.out.print("Fibonacci Sequence (Recursive): ");
    //     for (int i = 0; i <= n; i++) {
    //         System.out.print(fibRecursive(i) + " ");
    //     }
    //     System.out.println();
    // }



    // Non-recursive (iterative) approach to calculate the nth Fibonacci number
    static int fibIterative(int n) {
        if (n <= 1) return n;

        int prev1 = 0, prev2 = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
    
  // Sequence print kara mhantle ki Un commemnt kra.following code
    
    // Function to print Fibonacci sequence using iteration
    // static void printFibonacciIterative(int n) {
    //     System.out.print("Fibonacci Sequence (Iterative): ");
    //     int prev1 = 0, prev2 = 1;
    //     System.out.print(prev1 + " ");
    //     if (n > 0) System.out.print(prev2 + " ");
        
    //     for (int i = 2; i <= n; i++) {
    //         int current = prev1 + prev2;
    //         System.out.print(current + " ");
    //         prev1 = prev2;
    //         prev2 = current;
    //     }
    //     System.out.println();
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to calculate Fibonacci sequence: ");
        int n = sc.nextInt();

        // // Print Fibonacci sequence and nth number using recursive method
        // printFibonacciRecursive(n);
        
        System.out.println("nth Fibonacci number (Recursive): " + fibRecursive(n));

        // // Print Fibonacci sequence and nth number using iterative method
        // printFibonacciIterative(n);
        
        System.out.println("nth Fibonacci number (Iterative): " + fibIterative(n));
    }
}


// How to run code: save file as Fibonacci.java and copy paste code in it.
//  Go to terminal 
//  Run command 1]  javac Fibonacci.java
// Run command  2]  Fibonacci.java


// Enter a number to calculate Fibonacci: 5
// Fibonacci number (Recursive): 5
// Fibonacci number (Iterative): 5


// Recursive Approach
// Time Complexity (TC):
// In the recursive approach, each call to fibRecursive(n) triggers two more calls, one for fibRecursive(n - 1) and another for fibRecursive(n - 2).

// This creates a binary tree of recursive calls, leading to an exponential time complexity of: O(2^n)

// This is because the function calculates many overlapping subproblems repeatedly, leading to redundant work.


// Space Complexity (SC):
// The space complexity is determined by the depth of the recursive call stack, which
// O(n) in the worst case.

// Each recursive call occupies space on the call stack until it returns, so for 
// n recursive calls, the space complexity is: O(n)

// -------------------------------------------------------------------------------
// Iterative (Non-Recursive) Approach
// Time Complexity (TC):

// The iterative approach uses a simple loop to calculate Fibonacci numbers up to n.
// Since the loop runs 𝑛− 1

// n−1 times, the time complexity is: O(n)

// Space Complexity (SC):

// The iterative approach only uses a constant amount of space to store the previous two Fibonacci numbers (prev1 and prev2) and the result, making the space complexity:O(1)
