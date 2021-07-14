package medium;

import java.util.HashMap;
import java.util.Map;

/** 整数转罗马数字
 *罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例1:
 * 输入:num = 3
 * 输出: "III"
 * 示例2:
 * 输入:num = 4
 * 输出: "IV"
 * 示例3:
 * 输入:num = 9
 * 输出: "IX"
 * 示例4:
 * 输入:num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例5:
 * 输入:num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 * 提示：
 * 1 <= num <= 3999
 */

public class Lc12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num >= 1000){
                sb.append("M");
                num -= 1000;
            }else if(num >= 900){
                sb.append("CM");
                num -= 900;
            }else if(num >= 500){
                sb.append("D");
                num -= 500;
            }else if(num >= 400){
                sb.append("CD");
                num -= 400;
            }else if(num >= 100){
                sb.append("C");
                num -= 100;
            }else if(num >= 90){
                sb.append("XC");
                num -= 90;
            }else if(num >= 50){
                sb.append("L");
                num -= 50;
            }else if(num >= 40){
                sb.append("XL");
                num -= 40;
            }else if(num >= 10){
                sb.append("X");
                num -= 10;
            }else if(num >= 9){
                sb.append("IX");
                num -= 9;
            }else if(num >= 5){
                sb.append("V");
                num -= 5;
            }else if(num >= 4){
                sb.append("IV");
                num -= 4;
            }else {
                sb.append("I");
                num--;
            }

        }
        return sb.toString();
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
