package week4;

import java.util.Arrays;

public class Problem6 {

    // ================= LINEAR SEARCH =================
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // ================= BINARY SEARCH INSERT POSITION =================
    public static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // insertion point
    }

    // ================= FLOOR =================
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // ================= CEILING =================
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        int[] risks = {50, 10, 100, 25};

        System.out.println("Original Risks:");
        System.out.println(Arrays.toString(risks));

        // Linear Search (unsorted)
        linearSearch(risks, 30);

        // Sort for Binary Search
        Arrays.sort(risks);

        System.out.println("\nSorted Risks:");
        System.out.println(Arrays.toString(risks));

        int target = 30;

        // Binary insertion point
        int pos = binaryInsertionPoint(risks, target);
        System.out.println("\nInsertion position for " + target + ": " + pos);

        // Floor & Ceiling
        int fl = floor(risks, target);
        int ce = ceiling(risks, target);

        System.out.println("Floor(" + target + "): " + fl);
        System.out.println("Ceiling(" + target + "): " + ce);
    }
}