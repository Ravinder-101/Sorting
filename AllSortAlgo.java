import java.util.*;

public class Main {

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minidx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (isSmaller(arr, j, minidx) == true) {
                    minidx = j;
                }
            }
            swap(arr, i, minidx);

        }


    }
    public static boolean isSmaller(int arr[], int i, int j) {
        if (arr[i] > arr[j]) {
            return false;
        } else {
            return true;
        }

    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isSmaller(arr, i, j)) {
                    swap(arr, i, j);
                }
            }
        }

    }
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (isSmaller(arr, j - 1, j) == false) {
                    swap(arr, j - 1, j);

                } else {
                    break;
                }


            }
        }

    }
    public static int[] mergeSort(int arr[], int lo, int hi) {

        if (lo == hi) {
            int bs[] = {
                arr[lo]
            };
            return bs;
        }

        int mid = (lo + hi) / 2;
        int larr[] = mergeSort(arr, lo, mid);
        int rarr[] = mergeSort(arr, mid + 1, hi);

        int ans[] = mergeSortedlist(larr, rarr);

        return ans;
    }
    public static int[] mergeSortedlist(int a[], int b[]) {
        int i = 0, j = 0, k = 0;
        int[] ans = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                ans[k] = a[i];
                i++;
                k++;
            } else {
                ans[k] = b[j];
                j++;
                k++;
            }
        }

        while (i < a.length) {
            ans[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            ans[k] = b[j];
            k++;
            j++;
        }


        return ans;

    }
    


    public static void main(String[] args) {
        // Selection sort
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // selectionSort(arr);

        // bubbleSort(arr);

        // insertionSort(arr);
        // int[] k = mergeSort(arr, 0, arr.length - 1);
        // print(k);

        // print(arr);
        


    }
}