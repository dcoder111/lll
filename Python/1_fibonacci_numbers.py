def recursive_fibonacci(n):
    if n <= 1:
        return n
    else:
        return recursive_fibonacci(n - 1) + recursive_fibonacci(n - 2)

def non_recursive_fibonacci(n):
    first = 0
    second = 1
    sequence = [first, second]
    for _ in range(n - 2):
        third = first + second
        sequence.append(third)
        first = second
        second = third
    print("Non-recursive Fibonacci sequence:", sequence)

if __name__ == "__main__":
    n = int(input("Enter the number of terms in the Fibonacci sequence: "))

    # Collecting and printing the recursive Fibonacci sequence
    recursive_sequence = [recursive_fibonacci(i) for i in range(n)]
    print("\nRecursive Fibonacci sequence:", recursive_sequence)
    
    # Printing the non-recursive Fibonacci sequence
    non_recursive_fibonacci(n)


# Enter the number of terms in the Fibonacci sequence: 7

# Recursive Fibonacci sequence: [0, 1, 1, 2, 3, 5, 8]
# Non-recursive Fibonacci sequence: [0, 1, 1, 2, 3, 5, 8]


# ------------------------------------------------------------------------------------------------------------------------
# code2: 
# def recursive_fibonacci(n):
#     if n <= 1:
#         return n
#     else:
#         return recursive_fibonacci(n - 1) + recursive_fibonacci(n - 2)

# def non_recursive_fibonacci(n):
#     first = 0
#     second = 1
#     print("Non-recursive Fibonacci sequence:")
#     print(first)
#     print(second)
#     for _ in range(n - 2):
#         third = first + second
#         first = second
#         second = third
#         print(third)

# if __name__ == "__main__":
#     n = int(input("Enter the number of terms in the Fibonacci sequence: "))
    
#     print("\nRecursive Fibonacci sequence:")
#     for i in range(n):
#         print(recursive_fibonacci(i))
    
#     non_recursive_fibonacci(n)
    
    
# Enter the number of terms in the Fibonacci sequence: 7


# # Output:
# # Recursive Fibonacci sequence:
# # 0
# # 1
# # 1
# # 2
# # 3
# # 5
# # 8
# # Non-recursive Fibonacci sequence:
# # 0
# # 1
# # 1
# # 2
# # 3
# # 5
# # 8
