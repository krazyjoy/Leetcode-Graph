## sliding window algorithm 

- 技巧: 將雙層迴圈改為單層
- 問題形式: 
  - 問題基於array, list, string type 資料結構
  - 找出 array subrange 中最長、最短或特定值得字串
  - ex: longest sequence, shortest sequence

1. use hashmap or dictionary to count a specific array input
2. outer loop increase window toward the right
3. reduce the window size by increasing the left pointer if some condition is met
4. store the min or max size based on the problem statement


```agsl

void slidingWindow(String s){
    Map<Character,Integer> window = new HashMap<>();
    int left=0, right=0;
    int n = s.length();
    while(right < n){
        /* extract right */
        char rightChar = s.charAt(right);
        right += 1;
        
        /* update window data */
        
        while(window needs shrink){
            char leftChar = s.charAt(left);
            left += 1;
            /* window data update */
        }
    }
}
```
### Maximum Subarray of size k

Given an integer array "nums", find the subarray with the largest sum, and return its sum
```agsl
    public int[] maxSubsequence(int[] nums, int k) {
        int left=0;
        int windowSum=0;
        int maxSum=Integer.MIN_VALUE;

        int start=0, end=0;
        for(int right=0; right<nums.length; right++){
            windowSum += nums[right];

            if(right-left+1 == k){
                if(windowSum > maxSum){
                    maxSum = windowSum;
                    start = left;
                    end = right;
                }
                windowSum -= nums[left];
                left += 1;
            }
        }
        return Arrays.copyOfRange(nums, start, end+1);    

    }
```


## 3. Longest Substring without repeating characters
```agsl
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start=0, end=0;
        int maxlen=0;
        int n = s.length();
        
        
        char[] chS = s.toCharArray();
        while(end < n){
            char c = chS[end];
            map.put(c, map.getOrDefault(c, 0)+1);
            
            while(map.get(c) > 1){
                char leftChar = chS[start];
                map.put(leftChar, map.get(leftChar)-1);
                start += 1;
            }
            maxlen = Math.max(maxlen, end-start+1);
            end += 1;
        }
        return maxlen;
    }
}
```


### Difference Between the Max and Min Average of all k-length continuous subarrays
1. store the 1st k elements to windowSum
2. iterate over the remaining indices, check the windowSum and update maxSum, minSum

```agsl
double AverageDifference(double arr[], int K){
        double sum = 0;
        for(int i=0; i<K; i++){
            sum += arr[i];
        }
        
        double minSum = sum;
        double maxSum = sum;
        
        for(int i=K; i<arr.length; i++){
            sum += arr[i] - arr[i-K];
            if(sum < minSum){
                minSum = sum;
            }
            
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        
        return (maxSum-minSum)/K;
    }
```


### Length of the longest substring that doesn't contain any vowels

1. outer loop expands right window
2. only add character to window substring if is not vowel
3. update length of substring if exceeds max substring length
```agsl
Set<Character> set = new HashSet<>();
set.add('a'), set.add('e'), set.add('i'), set.add('o'), set.add('u');
result = "";
maxResult = "";

for(int right=0; right<s.length(); right++){
    char rightChar = s.charAt(right);
    if(!set.contains(rightChar)){
        result += rightChar;
        if (result.length() > maxResult.length()){
            maxResult = result;
        }
    }
}

return maxResult.length();
```

### Count Negative Elements Present In Every K-length Subarray
1. outer loop adds new element if is negative
2. check if length == k: 
3. true: store count for this k-length subarray
4. check if left element is negative
5. true: minus 1 in count
6. left index + 1

### Minimum Size Subarray Sum
Input: target = 7, nums = [2,3,1,2,4,3];
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint

1. keep adding num to sum
2. remove the left element until sum < target
3. update the minLen
```agsl
int left=0;
int len=0;
int minLen = Integer.MAX_VALUE;
int currSum = 0;

for(int right=0; right<nums.length; right++){
    currSum += nums[right];
    while(currSum > target){
        minLen = Math.min(right-left+1, minLen);
        currSum -= nums[left];
        left+=1;
    }
    if(minLen == Integer.MAX_VALUE)
        return 0;
    return minLen;
}
```

### Longest Repeating Character Replacement
https://leetcode.com/problems/longest-repeating-character-replacement/solutions/4420284/easy-java-solution-detailed-explanation-of-sliding-window-approach/

1. outer loop iterate over string s
2. use a freq array or a hashmap to remember char occurrence
3. condition to shrink: when the (occurrence of current index + replacement k)< (length of window)
4. --------- update the maxCnt
5. --------- decrease 1 occurrence of left index from map/array
6. res = (maxCnt, right-left+1)

### Permutation in String
Given two strings s1, s2 return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba")

**need to be substring permutation, use sliding window, limit to be the length of s1**

```agsl
int[] num1 = new int[26];
int[] num2 = new int[26];

for(int i=0; i<s1.length(); i++)
    num1[s1.charAt(i)-'a'] += 1;
    
int left=0;
for(int right=0; right<s2.length(); right++){
    num2[s2.charAt(right)-'a'] += 1;
    if(right-left > s1.length()){
        if(isEqualArray(num1, num2)){
            return true;
        }    
        num2[s2.charAt(left)-'a'] -= 1;
        left+= 1;
    }
    return false;
}

public static boolean isEqualArray(int[] num1, int[] num2){
    if(num1.length != num2.length)
        return false;
    for(int i=0; i<26; i++){
            if(num1[i] != num2[i]){
                return false; 
            }
        }
    }
    return true;
}
```

### Find All Anagrams In A String

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
substring with start index=0 is "cba", which is an anagram of "abc".
substring with start index=6 is "bac", which is an anagram of "abc".
```agsl
List<Integer> anagramIndices = new ArrayList<>();
int[] anagram = new int[26];
int[] word = new int[26];
for(int i=0; i<p.length(); i++){
    anagram[p.charAt(i)-'a'] += 1;
}
int left=0;
for(int right=0; right<s.length(); right++){
    word[s.charAt(right)-'a'] += 1;
    if(right-left+1 > p.length()){
        if(isEqual(word, anagram)){
            anagramIndices.add(left);
        }
        word[s.charAt(left)-'a'] -= 1;
        left+= 1;
    }
}
return anagramIndices;
```