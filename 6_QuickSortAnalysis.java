// Write a program for analysis of quick sort by using deterministic and randomized variant


import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSortAnalysis {

    // Deterministic QuickSort using last element as pivot
    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = deterministicPartition(arr, low, high);
            deterministicQuickSort(arr, low, pivotIndex - 1);
            deterministicQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int deterministicPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Randomized QuickSort
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        swap(arr, pivotIndex, high); // Move pivot to end
        return deterministicPartition(arr, low, high);
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to print the array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt(); // Read array size from user

        Random rand = new Random();
        int[] arr = new int[n];

        // Generate a random array
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Clone the array to use the same input for both sorting methods
        int[] arrForDeterministic = arr.clone();
        int[] arrForRandomized = arr.clone();

        // Measure time for deterministic quicksort
        long startTime = System.nanoTime();
        deterministicQuickSort(arrForDeterministic, 0, n - 1);
        long endTime = System.nanoTime();
        long deterministicDuration = endTime - startTime;

        // Measure time for randomized quicksort
        startTime = System.nanoTime();
        randomizedQuickSort(arrForRandomized, 0, n - 1);
        endTime = System.nanoTime();
        long randomizedDuration = endTime - startTime;

        // Output results
        System.out.println("Time taken by Deterministic Quick Sort: " + deterministicDuration + " nanoseconds");
        System.out.println("Time taken by Randomized Quick Sort: " + randomizedDuration + " nanoseconds");

        // Print the sorted arrays
        System.out.println("Sorted array using Deterministic Quick Sort: ");
        printArray(arrForDeterministic);

        System.out.println("Sorted array using Randomized Quick Sort: ");
        printArray(arrForRandomized);
        
        // // Verify if both sorted arrays are the same
        // System.out.println("Arrays are equal after sorting: " + Arrays.equals(arrForDeterministic, arrForRandomized));

    }
}

// OUTPUT :
// Enter the size of the array: 4
// Time taken by Deterministic Quick Sort: 9100 nanoseconds
// Time taken by Randomized Quick Sort: 12500 nanoseconds
// Sorted array using Deterministic Quick Sort:
// [5310, 20852, 68270, 77883]
// Sorted array using Randomized Quick Sort:
// [5310, 20852, 68270, 77883]
