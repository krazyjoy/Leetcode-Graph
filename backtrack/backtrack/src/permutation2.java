import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a collection of numbers, "nums", that might contain duplicates,
    return all possible unique permutations in any order


     use a freq map to keep track of current sequence
     termination: check if freq goes to zero
     edge case:  adjacent appearance of nums, do not add to collections


     - minus 1 freq
     - add to current sequence
     backtrack()
     - add 1 freq
     - remove from current sequence

 */
public class permutation2 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,1,2
        };
        System.out.println(permuteUnique(nums));
        int[] nums2 = new int[]{
                1,2,3
        };
        System.out.println(permuteUnique(nums2));
    }
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            if(!freq.containsKey(num)){
                freq.put(num, 1);
            }
            else{
                freq.put(num, freq.get(num)+1);
            }
        }
        backtrack(result, new ArrayList<>(), freq, nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> permuteList, Map<Integer,Integer> freq, int[] nums){
        if(permuteList.size() == nums.length){
            result.add(new ArrayList<>(permuteList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            // number has already seen
            if(freq.get(nums[i]) == 0){
                continue;
            }
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            permuteList.add(nums[i]);
            freq.put(nums[i], freq.get(nums[i])-1);
            backtrack(result, permuteList, freq, nums);
            freq.put(nums[i], freq.get(nums[i])+1);
            permuteList.remove(permuteList.size()-1);
        }
    }
}
