package maximum_swap;

import java.util.Arrays;

/*
    You are given an integer num. You can swap two digits at most once to get the max valued number
    return max valued number you can get.

    e.g. num = 2736
    output = 7236
    (swap 2 and 7)

    e.g. num = 9973
    output = 9973
    (no swap)
 */
public class maximum_swap {
    public static void main(String[] args) {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }


    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        /* store digit by its index in num through an inverse array data structure */

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            /* candidate digit value num[i] ~ 9 */
            for (int k = 9; k > digits[i] - '0'; k--) {
                /* check if this digit is on the right side */
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }

}
