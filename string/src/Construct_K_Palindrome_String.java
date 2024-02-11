/*
    1400. Construct K Palindrome Strings
    Given a string s and integer k,
    return true if you can use all characters in s to construct k palindrome strings or false
    *note: the order of characters in s does not matter*

    brainstorm:
        - place some single occurrence char at the middle
        - place even occurrence chars at the front and back

        - if k given is the string length -> return true (each char is its own palindrome)
        - check the occurrence of odd frequency chars
            - if odd freq chars < k: can construct

 */


public class Construct_K_Palindrome_String {
    public static void main(String[] args) {
        String s = "annabelle";
        int k=2;
        System.out.println(canConstruct(s, k));

    }
    public static boolean canConstruct(String s, int k){
        int n = s.length();
        int odd = 0;
        int[] count = new int[26];

        for(int i=0; i<n; i++){
            count[s.charAt(i) - 'a'] ^=1; // xor 1
            odd += count[s.charAt(i)-'a'] > 0 ? 1:-1;
        }
        return odd<=k && k<=n;
    }
}
