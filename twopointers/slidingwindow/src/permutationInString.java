import java.util.Arrays;

public class permutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("acb", "eidbcaooo"));
    }
    public static boolean checkInclusion(String s1, String s2){
        int[] num1 = new int[26];
        int[] num2 = new int[26];

        for(int i=0; i<s1.length(); i++)
            num1[s1.charAt(i)-'a'] += 1;

        int left=0;
        for(int right=0; right<s2.length(); right++){
            num2[s2.charAt(right)-'a'] += 1;
            if(right-left + 1 ==  s1.length()){
                if(isEqualArray(num1, num2)){
                    return true;
                }
                num2[s2.charAt(left)-'a'] -= 1;
                left+= 1;
            }

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

        return true;
    }
}
