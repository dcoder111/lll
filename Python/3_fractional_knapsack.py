def fractional_knapsack():
    weights = list(map(int, input("Enter the weights of the items (comma separated): ").split(',')))
    values = list(map(int, input("Enter the values of the items (comma separated): ").split(',')))
    capacity = int(input("Enter the maximum capacity of the knapsack: "))
    
    # Check if the length of weights and values are the same
    if len(weights) != len(values):
        print("Error: The number of weights and values must be the same.")
        return
    
    res = 0  # To store the maximum value that can be achieved
    # Pair each weight with its corresponding value and sort by value-to-weight ratio in descending order
    for pair in sorted(zip(weights, values), key=lambda x: x[1] / x[0], reverse=True):
        if capacity <= 0:  # If the knapsack is fully filled
            break
        if pair[0] > capacity:  # If the item can't fit fully, take the fractional part
            res += capacity * (pair[1] / pair[0])  # Take the fraction of the item to fill the knapsack
            capacity = 0  # Knapsack is now full
        else:  # If the item can fit fully, take it all
            res += pair[1]
            capacity -= pair[0]
    
    print(f"Maximum value in the knapsack: {res}")

if __name__ == "__main__":
    fractional_knapsack()


# Enter the weights of the items (comma separated): 10,20,30
# Enter the values of the items (comma separated): 60,100,120
# Enter the maximum capacity of the knapsack: 50
# Maximum value in the knapsack: 240.0
