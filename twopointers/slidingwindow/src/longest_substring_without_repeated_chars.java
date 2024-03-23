/*
    Given a string s, find the length of the longest substring without
    repeating characters

    ex: s = "abcabcbb"
    output = 3
    ex: s = "bbbbb"
    output = 1
    ex: s = "pwwkew"
    output = 3

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longest_substring_without_repeated_chars {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(getLongestSubString("bcbdbdbbdcdabd'", 2));
        String s2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));
    }
    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int left=0, right=0;
        int maxLen=0;
        int n = s.length();
        while(right < n){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.get(c) > 1){
                // found repeated character, move left index by 1
                // start new substring
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left += 1;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right += 1;

        }
        return maxLen;
    }

    public static String getLongestSubString(String s, int k){
        int right=0, left=0;
        int[] freq = new int[128];
        Set<Character> set = new HashSet<>();
        int start=0, end=0;
        while(right<s.length()) {
            char rightChar = s.charAt(right);
            set.add(rightChar);
            freq[rightChar - 'a'] += 1;
            while (set.size() > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a'] -= 1;
                if (freq[leftChar - 'a'] == 0)
                    set.remove(leftChar);
            }
            left += 1;

            if (end - start < right - left) {
                end = right;
                start = left;
            }
            right += 1;
        }
        return s.substring(start, end+1);
    }
}

