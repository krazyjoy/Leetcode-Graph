package romanized;

import java.util.HashMap;
import java.util.Map;

public class romanized {
    public static int romanToInt(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            if(i < n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans -= map.get(s.charAt(i));
            }
            else{
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}