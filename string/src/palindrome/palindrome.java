package palindrome;

/*
    deal with odd and even palindrome
    way1.
    - int(n/2) only retrieves the first half without the middle element if odd array
    - convert int to string: i v.s. n-i-1

    way2.
    store one half of the integer in another variable in reversed order
    - compare reversed half integer with unaltered half of number

 */
public class palindrome {
    public static boolean isPalindrome(int x){
        String s = String.valueOf(x);
        int n = s.length();

        for(int i=0; i<n/2; i++){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }

    public static boolean isPalindrome2(int x){
        if(x < 0 || (x != 0 && x% 10 == 0)){
            return false;
        }
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (x == rev || x == rev/10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(10));
    }
}
