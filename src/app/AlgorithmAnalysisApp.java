package app;

import java.util.*;

public class AlgorithmAnalysisApp {

    static class Transaction {
        String id;
        double fee;
        String time;

        Transaction(String id, double fee, String time) {
            this.id = id;
            this.fee = fee;
            this.time = time;
        }

        public String toString() {
            return id + ":" + fee + "@" + time;
        }
    }

    // Bubble Sort (ascending fee)
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    // Insertion Sort (fee + timestamp)
    public static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1",10.5,"10:00"));
        list.add(new Transaction("id2",25.0,"09:30"));
        list.add(new Transaction("id3",5.0,"10:15"));

        bubbleSort(list);
        System.out.println("Bubble Sort: " + list);

        insertionSort(list);
        System.out.println("Insertion Sort: " + list);

        System.out.println("High Fee >50:");
        for (Transaction t : list) {
            if (t.fee > 50) System.out.println(t);
        }
    }
}