import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        ArrayList<Integer> bubbleSortedList = new ArrayList<>(integerList);  
        long startBubbleSort = System.nanoTime();
        Lab4.bubbleSort(bubbleSortedList);
        long endBubbleSort = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nBubble sort time: " + (endBubbleSort - startBubbleSort) + " ns");

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        ArrayList<Integer> insertionSortedList = new ArrayList<>(integerList); 
        long startInsertionSort = System.nanoTime();
        Lab4.insertionSort(insertionSortedList);
        long endInsertionSort = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.println("\nInsertion sort time: " + (endInsertionSort - startInsertionSort) + " ns");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        // Step 1 - Implement insertion sort algorithm here
        for (int i = 1; i < integerList.size(); i++) {
            int key = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j--;
            }
            integerList.set(j + 1, key);
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        // Step 2 - Implement the bubble sort algorithm here
        int n = integerList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                }
            }
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
        System.out.println();
    }
}
/*
1. If you were implementing a sort algorithm for a new language, which sort would you use?
   - I would use a more efficient algorithm like QuickSort or MergeSort, as they are generally faster than Bubble Sort or Insertion Sort for larger datasets. 
     These have average-case time complexity of O(n log n) compared to O(n^2) for Bubble Sort and Insertion Sort.

2. Was there a difference in the time it took for bubble and insertion sort to run? Does this make sense given the time complexities for these sorting algorithms?
   - Yes, there may be a difference in runtime, as Bubble Sort and Insertion Sort both have O(n^2) time complexity in the average case. However, Insertion Sort is generally faster than Bubble Sort 
     for smaller or partially sorted arrays, making the difference in runtime noticeable. This aligns with their time complexities.

3. Which sort algorithm has an easier implementation (in terms of understanding) to you?
   - Bubble Sort seems easier to understand and implement because it only involves repeated pairwise comparisons and swaps, 
     while Insertion Sort requires shifting elements in place, which can be more complex to visualize.
*/