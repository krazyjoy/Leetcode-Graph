import java.util.*;

public class NegativeElementsInKSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,-2,3,5,-7,-5};
        int k=3;
        System.out.println(getCountNegatives(arr, k)); // [2, 1, 1, 1, 2]
    }
    public static List<Integer> getCountNegatives(int[] arr, int k){
        int left=0;
        int windowLength=0;

        List<Integer> lengths = new ArrayList<>();
        for(int right=0; right<arr.length; right++){

            if(arr[right]<0){
                windowLength += 1;

            }
            if(right-left+1 == k){
                lengths.add(windowLength);
                if(arr[left] < 0){
                    windowLength -= 1;
                }
                left += 1;
            }

        }
        return lengths;
    }
}
