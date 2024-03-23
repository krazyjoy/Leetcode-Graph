/*
    Given an integer array "nums", move all "0"'s to the end of it while
    maintaining the relative order of the non-zero elements

    nums = [0, 1, 0, 3, 12]
    -> [1, 3, 12, 0, 0]

 */

import java.util.Arrays;

public class moveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 4, 0, 2};
        moveZeros(nums);
    }
    public static void moveZeros(int[] nums){
        int left=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left += 1;
            }
        }

        for(int i=left; i<nums.length; i++){
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
