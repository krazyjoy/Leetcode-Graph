import java.util.Arrays;

public class ApplyOperationToAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,1,0};
        applyOperations(nums);
    }
    /*
        You are given a 0-indexed array "nums" of size n, consisting of non-negative integers
        You need to apply n-1 operations to the array
        if nums[i] == nums[i+1]:
            multiply nums[i] by 2,
            set nums[i+1] to 0
        after performing all operations, shift all 0's to the end of the array
        e.g. [1,0,2,0,0,1] -> [1,2,1,0,0,0]

     */
    public static int[] applyOperations(int[] nums){

        for(int right=0; right<nums.length-1; right++){
            if(nums[right] == nums[right+1]) {
                nums[right] *= 2;
                nums[right + 1] = 0;
            }
        }
        for(int i=0, left=0; i<nums.length; i++){
            if(nums[i]!=0){
                /* set nums[i] = 0, after changing nums[left] to nums[i]
                 */

                int tmp = nums[i];
                nums[i] = 0;
                nums[left] = tmp;
                left += 1;
            }

        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
