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

    static class Client {
        String name;
        int risk;
        int balance;

        Client(String n, int r, int b) {
            name = n;
            risk = r;
            balance = b;
        }
    }

    // Bubble Sort ascending risk
    public static void sortClientsBubble(List<Client> list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                if (list.get(j).risk > list.get(j+1).risk) {
                    Collections.swap(list,j,j+1);
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    static void merge(int[] arr,int l,int m,int r){
        int[] temp = new int[r-l+1];
        int i=l,j=m+1,k=0;

        while(i<=m && j<=r){
            if(arr[i]<=arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while(i<=m) temp[k++]=arr[i++];
        while(j<=r) temp[k++]=arr[j++];

        for(int x=0;x<temp.length;x++) arr[l+x]=temp[x];
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];arr[i]=arr[j];arr[j]=temp;
            }
        }
        int temp=arr[i+1];arr[i+1]=arr[high];arr[high]=temp;
        return i+1;
    }

    public static int linearSearch(String[] arr, String key){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(key)) return i;
        }
        return -1;
    }
}
