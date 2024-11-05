import random
import time
# dcoder UM
def deterministic_quick_sort(arr, low, high):
    if low < high:
        pivot_index = deterministic_partition(arr, low, high)
        deterministic_quick_sort(arr, low, pivot_index - 1)
        deterministic_quick_sort(arr, pivot_index + 1, high)

def deterministic_partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

def randomized_quick_sort(arr, low, high):
    if low < high:
        pivot_index = randomized_partition(arr, low, high)
        randomized_quick_sort(arr, low, pivot_index - 1)
        randomized_quick_sort(arr, pivot_index + 1, high)

def randomized_partition(arr, low, high):
    random_pivot_index = random.randint(low, high)
    arr[random_pivot_index], arr[high] = arr[high], arr[random_pivot_index]
    return deterministic_partition(arr, low, high)

def measure_time(func, arr):
    start_time = time.time()
    func(arr, 0, len(arr) - 1)
    end_time = time.time()
    return end_time - start_time

if __name__ == "__main__":
    n = int(input("Enter number of elements: "))
    original_array = [random.randint(1, 1000) for _ in range(n)]
    
    print("\nOriginal array:", original_array)

    # Deterministic Quick Sort
    array_copy = original_array.copy()
    time_deterministic = measure_time(deterministic_quick_sort, array_copy)
    print("\nSorted array (Deterministic QuickSort):", array_copy)
    print("Time taken by Deterministic QuickSort: {:.6f} seconds".format(time_deterministic))

    # Randomized Quick Sort
    array_copy = original_array.copy()
    time_randomized = measure_time(randomized_quick_sort, array_copy)
    print("\nSorted array (Randomized QuickSort):", array_copy)
    print("Time taken by Randomized QuickSort: {:.6f} seconds".format(time_randomized))

# Enter number of elements: 5

# Original array: [603, 87, 675, 853, 773]

# Sorted array (Deterministic QuickSort): [87, 603, 675, 773, 853]
# Time taken by Deterministic QuickSort: 0.000000 seconds

# Sorted array (Randomized QuickSort): [87, 603, 675, 773, 853]
# Time taken by Randomized QuickSort: 0.000000 seconds
