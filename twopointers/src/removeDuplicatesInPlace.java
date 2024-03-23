import java.util.Arrays;

/*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    26. Remove Duplicates From Sorted Array

    Let slow pointer to walk behind fast pointer, fast pointer looks for next unique element,
    if found, make the value be assigned to slow pointer, and move slow pointer to the next position

    nums[0...slow]: unique elements
 */
public class removeDuplicatesInPlace {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};

        System.out.println(Arrays.toString(removeDuplicates(nums)));
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(removeDuplicates(nums2)));
    }
    public static int[] removeDuplicates(int[] nums){
        int left=1;
        for(int right=1; right<nums.length; right++){
            if(nums[right-1] != nums[right]){
                nums[left] = nums[right];
                left += 1;
            }
        }
        return Arrays.copyOfRange(nums, 0, left);
    }
}
