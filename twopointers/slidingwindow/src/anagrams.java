import java.util.ArrayList;
import java.util.List;

public class anagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p){
        int[] wordMap = new int[26];
        int[] patternMap = new int[26];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<p.length(); i++){
            patternMap[p.charAt(i) - 'a'] += 1;
        }
        int startWindow=0;
        for(int j=0; j<s.length(); j++){
            // add char to wordMap
            wordMap[s.charAt(j) - 'a'] += 1;

            // window capacity exceeded
            if(j - startWindow + 1 > p.length()){
                wordMap[s.charAt(startWindow) - 'a'] -= 1;
                startWindow += 1;
            }

            // check if freq maps match

            if(j - startWindow + 1 == p.length() && isAnagram(wordMap, patternMap)){
                result.add(startWindow);
            }
        }
        return  result;
    }

    public static boolean isAnagram(int[] wordMap, int[] patternMap){
        for(int i=0; i<26; i++){
            if(wordMap[i] != patternMap[i]){
                return false;
            }
        }
        return true;
    }
}
