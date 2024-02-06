package MergeSort;

import java.util.Arrays;

/*
    Merge:
        everytime choose the smaller element from the left subarray or from the right subarray
        l: left start index
        r: right start index
        to a new array with i: index to fill

 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,1,4};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);

    }
    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmpArray = Arrays.copyOf(arr, arr.length);
        for(int i=left; i<right; i++){
            tmpArray[i] = arr[i];
        }
        int l=left, r=mid+1, i=left;

        while(l<=mid && r<=right){
            // find the smallest from left subarray & right subarray
            if(tmpArray[l] < tmpArray[r]){
                arr[i] = tmpArray[l];
                l+=1;
                i+=1;
            }
            else{
                arr[i] = tmpArray[r];
                r += 1;
                i += 1;
            }
        }
        // place the remaining left subarray to array
        while(l <= mid){
            arr[i] = tmpArray[l];
            l += 1;
            i += 1;
        }

    }

}
