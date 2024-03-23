public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubarrayLen(7, nums));
    }
    public static int minSubarrayLen(int target, int[] nums){
        int left=0;
        int currSum = 0;
        int minCnt=Integer.MAX_VALUE;
        for(int right=0; right<nums.length; right++){
            currSum += nums[right];

            while(currSum >= target){
                minCnt = Math.min(minCnt, right-left+1); // includes checking currSum == target
                currSum -= nums[left];
                left += 1;
            }
            if(minCnt == Integer.MAX_VALUE){
                return 0;
            }
        }
        return minCnt;
    }
}
