package easy;

import java.util.Arrays;

public class Lc66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i = length-1; i >= 0; i--){
            if(++digits[i] % 10 != 0) return digits;
            digits[i] = 0;
        }
        digits = new int[length + 1];
        // 遗漏
        digits[0] = 1;
        return digits;
    }
}
