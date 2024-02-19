/*
    Given an integer num.
    Pick a digit x, another digit y.
    Replace all the occurrences of x in the decimal representation of num by y.

    a: apply operations to num first time
    b: apply operations to num second time

    return max difference between a and b

    brainstorm:
    find max and min of num, then compute the max difference

    max transformed: first non 9 digit from highest possible digit

    min transformed:
        if first digit is 1, first non 1 digit change to 0
        if first digit is not 1, change to 1
 */
public class max_diff_from_changing_an_integer {
    public static void main(String[] args) {
        int num = 555;
        System.out.println(maxDiff(num));
        System.out.println(maxDiff(767));
    }
    public static int maxDiff(int num){
        int max = findMax(num);
        int min = findMin(num);
        return max-min;
    }

    public static int findMax(int num){
        char[] digits = Integer.toString(num).toCharArray();

        char maxDigit = '9';
        char highest_order = '0';
        for(int i=0; i<digits.length; i++){
            if(digits[i] != '9'){
                highest_order = digits[i];
                break;
            }
        }
        /* check common digits */
        for(int i=0; i<digits.length; i++){
            if(digits[i] == highest_order){
                digits[i] = '9';
            }
        }
        return Integer.parseInt(new String(digits));
    }

    public static int findMin(int num){
        char[] digits = Integer.toString(num).toCharArray();
        char highest_order = '0';
        char replace ='0';
        if(digits[0] == '1'){
            for(int i=1; i<digits.length; i++){
                if(digits[i] != '0' && digits[i] != '1'){
                    highest_order = digits[i];
                    replace = '0';
                    break;
                }
            }
        }else{
            highest_order = digits[0];
            replace = '1';
        }

        for(int i=0; i<digits.length; i++){
            if(digits[i] == highest_order){
                digits[i] = replace;
            }
        }
        return Integer.parseInt(new String(digits));

    }

}
