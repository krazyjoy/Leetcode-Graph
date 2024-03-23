import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestRepeatingCharReplacement {
    public static void main(String[] args) {
        System.out.println(replaceLongestRepeatingChar("ABAB", 2));

    }

    // keep adding substring if k > 0
    public static int replaceLongestRepeatingChar(String s, int k){
        int left=0;
        int maxCnt=0;
        int res=0;
        char[] stringArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int right;
        for(right=0; right<s.length(); right++){
            map.put(stringArr[right], map.getOrDefault(stringArr[right], 0)+1);
            maxCnt = Math.max(maxCnt, map.get(stringArr[right]));
            // exceed the possible replacement credit the current element's occurrence + k
            if(right-left+1 > maxCnt + k){
                map.put(stringArr[left], map.get(stringArr[left])-1);
                left += 1;
            }
            res = Math.max(res, right-left+1);
        }

        return res;
    }
}
