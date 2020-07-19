import java.util.Scanner;

public class Selectionsort {

    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minidx = i;
            for(int j=i+1;j<arr.length;j++){
                if(isSmaller(arr, j ,minidx) ){
                    minidx = j;
                }
            }
            Swap(arr, i , minidx);
        }
        
    }
    public static boolean isSmaller(int arr[] , int i, int j){
        if(arr[i] <= arr[j]){
            return true;
        }else{
            return false;
        }
    }
    public static void Swap(int arr[] , int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        
        
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        selectionSort(arr);
        print(arr);
        


    }
    
}