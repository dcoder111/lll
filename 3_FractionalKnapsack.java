import java.util.*;

class Item {
    int value, weight;
    
    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);
        if (r1 < r2) return 1;
        else if (r1 > r2) return -1;
        else return 0;
    }
}

public class FractionalKnapsack {
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());

        int curWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        Item arr[] = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            arr[i] = new Item(value, weight);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int weight = sc.nextInt();

        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);

        sc.close();
    }
}


// Time Complexity : O(nlogn) for sorting + N for Loop
// Space Complexity: O(n), primarily for storing the input items.
  
//Output:
// Enter the number of items: 5
// Enter value of item 1: 30
// Enter weight of item 1: 5
// Enter value of item 2: 40
// Enter weight of item 2: 10
// Enter value of item 3: 45
// Enter weight of item 3: 15
// Enter value of item 4: 77
// Enter weight of item 4: 22
// Enter value of item 5: 90
// Enter weight of item 5: 25
// Enter the capacity of the knapsack: 60
// The maximum value is 230.0
