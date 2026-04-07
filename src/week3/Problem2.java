package week3;

import java.util.Arrays;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + " (Bal:" + accountBalance + ")";
    }
}

public class Problem2 {

    // ================= BUBBLE SORT (ASC) =================
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("\nBubble Sort (Ascending by riskScore):");
        printArray(arr);
        System.out.println("Swaps: " + swaps);
    }

    // ================= INSERTION SORT (DESC + BALANCE) =================
    public static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||   // DESC
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (DESC riskScore + balance):");
        printArray(arr);
    }

    // ================= TOP 10 =================
    public static void topHighRisk(Client[] arr) {
        System.out.println("\nTop High Risk Clients:");

        int limit = Math.min(10, arr.length);
        for (int i = 0; i < limit; i++) {
            System.out.println(arr[i]);
        }
    }

    // ================= PRINT =================
    public static void printArray(Client[] arr) {
        for (Client c : arr) {
            System.out.print(c + "  ");
        }
        System.out.println();
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        System.out.println("Original Clients:");
        printArray(clients);

        // Bubble Sort
        Client[] bubbleArr = Arrays.copyOf(clients, clients.length);
        bubbleSort(bubbleArr);

        // Insertion Sort
        Client[] insertionArr = Arrays.copyOf(clients, clients.length);
        insertionSort(insertionArr);

        // Top risk clients (after sorting DESC)
        topHighRisk(insertionArr);
    }
}