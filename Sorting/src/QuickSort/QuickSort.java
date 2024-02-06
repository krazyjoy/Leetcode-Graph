package QuickSort;

import java.util.Arrays;

/*
    QuickSort => Pivot

    After sorting, pivot element in the array should be in correct position
    Items to the left are smaller
    Items to the right are greater

    Each pivot index, swap to the rightmost index
    Find the first left index greater than pivot value, and the first right index less than the pivot value
    swap(left, right)
    swap(pivot, n-1)

 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,8,4,5,1};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot-1);
            quicksort(arr, pivot+1, high);
        }

    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int pos = low-1;

        for(int j=low; j <= high; j++){
            if(arr[j] < pivot){ // place elements smaller than pivot on the left
                pos += 1;
                swap(arr, pos, j);
            }
        }
        swap(arr, pos+1, high);
        return pos+1;
    }
    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;

    }
}
