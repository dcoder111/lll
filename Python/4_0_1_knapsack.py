def solve_knapsack():
    # Taking input from the user
    val = list(map(int, input("Enter the values of the items (comma separated): ").split(',')))
    wt = list(map(int, input("Enter the weights of the items (comma separated): ").split(',')))
    W = int(input("Enter the maximum capacity of the knapsack: "))

    # Check if the length of values and weights are the same
    if len(val) != len(wt):
        print("Error: The number of values and weights must be the same.")
        return
    
    n = len(val) - 1  # Last index of items

    def knapsack(W, n):
        # Base case
        if n < 0 or W <= 0:
            return 0
        
        # Exclude item if weight is more than the remaining capacity
        if wt[n] > W:
            return knapsack(W, n - 1)
        
        # Include or exclude item and choose the maximum value
        else:
            return max(val[n] + knapsack(W - wt[n], n - 1), knapsack(W, n - 1))
    
    # Calling the knapsack function and printing the result
    print("Maximum value in the knapsack:", knapsack(W, n))

if __name__ == "__main__":
    solve_knapsack()


# Enter the values of the items (comma separated): 3,4,5,6
# Enter the weights of the items (comma separated): 2,3,4,6
# Enter the maximum capacity of the knapsack: 5
# Maximum value in the knapsack: 7



#-------------------------------------------------------------------------------------------------------------
# Code 2:
# def solve_knapsack():
#     # Taking input from the user
#     val = list(map(int, input("Enter the values of the items (comma separated): ").split(',')))
#     wt = list(map(int, input("Enter the weights of the items (comma separated): ").split(',')))
#     W = int(input("Enter the maximum capacity of the knapsack: "))

#     # Check if the length of values and weights are the same
#     if len(val) != len(wt):
#         print("Error: The number of values and weights must be the same.")
#         return
    
#     n = len(val)  # Number of items
    
#     # Memoization table to store results of subproblems
#     dp = [[-1 for _ in range(W + 1)] for _ in range(n + 1)]

#     # Recursive knapsack function with memoization
#     def knapsack(W, n):
#         if n == 0 or W == 0:
#             return 0
#         if dp[n][W] != -1:
#             return dp[n][W]
        
#         if wt[n - 1] > W:
#             dp[n][W] = knapsack(W, n - 1)
#         else:
#             dp[n][W] = max(
#                 val[n - 1] + knapsack(W - wt[n - 1], n - 1),
#                 knapsack(W, n - 1)
#             )
#         return dp[n][W]

#     # Function to find selected items
#     def find_selected_items():
#         selected_items = []
#         remaining_capacity = W
#         for i in range(n, 0, -1):
#             # Check if the item was included in the optimal solution
#             if dp[i][remaining_capacity] != dp[i - 1][remaining_capacity]:
#                 selected_items.append((wt[i - 1], val[i - 1]))  # Append weight and value of item
#                 remaining_capacity -= wt[i - 1]
#         return selected_items

#     # Call the knapsack function and fill the dp table
#     max_value = knapsack(W, n)
#     selected_items = find_selected_items()

#     # Output results
#     print("Maximum value in the knapsack:", max_value)
#     print("Selected items (weight, value):", selected_items)

# if __name__ == "__main__":
#     solve_knapsack()


# # Enter the values of the items (comma separated): 3,4,5,6
# # Enter the weights of the items (comma separated): 2,3,4,6
# # Enter the maximum capacity of the knapsack: 5
# # Maximum value in the knapsack: 7
# # Selected items (weight, value): [(3, 4), (2, 3)]
