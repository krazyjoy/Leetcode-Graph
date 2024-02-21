/*
    567. Permutation In String
    https://leetcode.com/problems/permutation-in-string/

 */

public class permutation_in_string {
    public boolean checkInclusion(String s1, String s2){

        int[] patternMap = new int[26];
        for(char c: s1.toCharArray()){
            patternMap[c-'a'] += 1;
        }

        int[] wordMap = new int[26];
        int left=0, right=0;
        while(right < s2.length()){
            wordMap[s2.charAt(right)-'a'] += 1;
            if(right-left+1 > s1.length()){
                wordMap[s2.charAt(left)-'a'] -= 1;
                left += 1;
            }

            if(right - left + 1 == s1.length() && isPermutation(wordMap, patternMap)){
                return true;
            }

            right += 1;
        }

        return false;
    }

    public boolean isPermutation(int[] wordMap, int[] patternMap){
        for(int i=0; i<26; i++){
            if(wordMap[i] != patternMap[i]){
                return false;
            }
        }

        return true;
    }
}
