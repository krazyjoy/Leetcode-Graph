/* sliding window algorithm */
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
