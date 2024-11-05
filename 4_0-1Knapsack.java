// Practical No.4
// Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and bound strategy.
    

import java.util.Scanner;
public class Knapsack 
{
    static int knapSack(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N + 1][W + 1]; // DP matrix

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) 
                {
                    dp[i][j] = 0; // Base case
                } 
                
                else if (wt[i - 1] <= j) 
                {
                    int take = val[i - 1] + dp[i - 1][j - wt[i - 1]]; 
                    int skip = dp[i - 1][j]; 
                    dp[i][j] = Math.max(take, skip);
                }
                
                else
                {
                    dp[i][j] = dp[i - 1][j]; 
                }
            }
        }

        return dp[N][W]; // Return the result stored at the last cell
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int W = 5; 
        int[] profit = {3,4,5,6};
        int[] wt = {2,3,4,6}; 
        int N = profit.length; 

        System.out.println(knapSack(N, W, profit, wt));
    }
}


// Time Complexity (TC) The time complexity is determined by the nested loops that iterate over the items N and weights 𝑊.
// The outer loop runs 𝑁 + 1  times (from 0 to 𝑁 ), representing the items. 
// The inner loop runs 𝑊 + 1 times (from 0 to 𝑊 ), representing the knapsack's weight capacity. 
// Thus, the time complexity is:  𝑂 ( 𝑁 × 𝑊 )

// Space Complexity (SC) The space complexity depends on the 2D array dp of size ( 𝑁 + 1 ) ×(𝑊 + 1 ) .
// The array dp takes up (N+1)×(W+1) space. Thus,
//  the space complexity is: 𝑂(𝑁×𝑊)
