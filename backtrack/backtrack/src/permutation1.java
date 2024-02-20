import java.util.ArrayList;
import java.util.List;

/*
    Given an array "nums" of distinct integers, return all the possible permutations.
    You are return the answer in any order.

    technique: list.contains()
    termination: size of list equals nums[]

*/
public class permutation1 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,3
        };

        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> permuteList = new ArrayList<>();
        backtrack(permuteList, new ArrayList<>(), nums);
        return permuteList;
    }
    public static void backtrack(List<List<Integer>> permuteList, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            permuteList.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(permuteList, list, nums);
            list.remove(list.size()-1);
        }
    }
}
