/*
     27. remove element: https://leetcode.com/problems/remove-element/description/

     nums = [0,1,2,2,3,0,4,2], val = 2
     nums = [0,1,3,0,4,_,_,_]

 */

import java.util.Arrays;

public class removeElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
    public static int removeElement(int[] nums, int val) {
        int left=0;
        for(int right=0; right<nums.length; right+=1){
            if(nums[right] != val){
                nums[left] = nums[right];
                left += 1;
            }
        }
        for(int i=left; i<nums.length; i++){
            nums[i] = -1;
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

}
