package week4;

import java.util.Arrays;

public class Problem5 {

    // ================= LINEAR SEARCH =================
    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("\nLinear Search:");
        if (first != -1) {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
        } else {
            System.out.println("Not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }

    // ================= BINARY SEARCH =================
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("\nBinary Search found at index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search: Not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // ================= COUNT OCCURRENCES =================
    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original Logs:");
        System.out.println(Arrays.toString(logs));

        // Linear Search
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");
        System.out.println(Arrays.toString(logs));

        // Binary Search
        binarySearch(logs, "accB");

        // Count occurrences
        int count = countOccurrences(logs, "accB");
        System.out.println("Total occurrences of accB: " + count);
    }
}