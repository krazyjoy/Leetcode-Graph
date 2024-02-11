/*
   677. https://leetcode.com/problems/map-sum-pairs/description/
   Design a map:
    - maps a string key to a given value
    - returns the sum of the values that have a key with a prefix equal to a given string


 */

import java.util.HashMap;
import java.util.Map;

public class Map_Sum_Pairs {
    public Map<String, Integer> map = new HashMap<>();
    public Map_Sum_Pairs(){

    }
    /* inserts the key-val pair into the map,
        if the key is already existed, the original key-value wil be overridden to the new one
     */
    public void insert(String key, int val){
        map.put(key, val);
    }
    /*
        returns the sum of all the pairs' value whose key starts with the prefix

     */
    public int sum(String prefix){
        int count=0;
        for(String k: map.keySet()){
            if(prefix.length() < k.length() && prefix.equals(k.substring(0, prefix.length()+1))){
                count += map.get(k);
            }
        }

        return count;
    }
}
