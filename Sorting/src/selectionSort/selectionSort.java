package selectionSort;

import java.util.Arrays;

/*
    Selection Sort:
    sorts in ascending order
    find the next right min element
    swap(pivot, next_right_min_index)
 */
public class selectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,2,9,3,7};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
    public static int[] selectionSort(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        int n = arr.length;
        for(int i=0; i<n; i++){ // pivot index
            int next_right_min = i;
            for(int j=i; j<n; j++){
                if(arr[j] < arr[next_right_min]){
                    next_right_min = j;
                }
            }
            swap(arr, i, next_right_min);
        }
        return arr;
    }
    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}

