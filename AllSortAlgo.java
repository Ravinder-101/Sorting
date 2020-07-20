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
    
    public static void quickSort(int arr[] , int lo  , int hi){
        if(lo<=hi){
        int pivot = arr[hi];
        int pivotidx = partition(arr,pivot, lo, hi);
        quickSort(arr, lo , pivotidx-1);
        quickSort(arr, pivotidx+1 , hi);
        }
        
    }
    public static int  partition(int arr[] , int pivot, int lo , int hi){
        int i =lo ,  j=lo;
        while(i <= hi){
            if(arr[i]<=pivot){
                swap(arr, i , j);
                i++;
                j++;
            }
            else{
                i++;
            }
            
            
        }
        return j-1;
    }
    public static void countSort( int arr[] , int max){
        
       int farr[] = new int[max+1];
       for(int i=0;i<arr.length;i++){
           farr[arr[i]]++;
       }
       int j = 0;
       for( int i = 0 ; i< farr.length ; i++ ){
           int temp = farr[i];
           while(temp!=0){
               arr[j] = i;
               j++;
               temp--;
           }
       }

    }
 
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val: arr) {
            if (val > max) {
                max = val;
            }
        }
        for (int exp = 1, itr = 1; max / exp > 0; exp = exp * 10) {
            CountSort(arr, exp, itr++);
        }

    }

    public static void CountSort(int arr[], int exp, int itr) {
      
        int farr[] = new int[10];
        for (int val: arr) {
            farr[(val/exp)%10]++;
        }
 
        for (int idx = 1; idx < 10; idx++) {
            farr[idx] = farr[idx-1] + farr[idx];
        }

     
        int ans[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[(val/exp)%10]--;
            ans[pos - 1] = val;
        }

  
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
        
    
    }
    
   


    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            if(arr[i] > max){
                max = arr[i];
            }
        }
        // selectionSort(arr);

        // bubbleSort(arr);

        // insertionSort(arr);
        // int[] k = mergeSort(arr, 0, arr.length - 1);
        // print(k);

        // print(arr);
        // quickSort(arr, 0, arr.length-1);
        // print(arr);
       /* countSort(arr , max);*/
       radixSort(arr);
        print(arr);
        


    }
}
