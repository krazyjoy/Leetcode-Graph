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
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums){
        int n = nums.length;
        int left=0, right=0;
        while(right < n){
            if(nums[left] != nums[right]){
                left += 1; // to avoid overwriting current unique value
                nums[left] = nums[right];
            }
            right += 1;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, left+1)));
        return left + 1;
    }
}
