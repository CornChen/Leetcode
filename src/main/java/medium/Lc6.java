package medium;

/** Z 字形变换
 *将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * solution1: 按行访问
 * solution2：按行排序
 * https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
 */
public class Lc6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    /** 按行访问
     对于所有整数 kk，
     行 0 中的字符位于索引 k*(2*numRows−2) 处;
     行 numRows−1 中的字符位于索引 k*(2*numRows - 2) + numRows − 1 处;
     内部的 行 i 中的字符位于索引 k*(2⋅numRows−2)+i 以及 (k + 1)(2*numRows−2)−i 处;
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int cyclen = 2 * numRows - 2, s_len = s.length();
        for(int row = 0; row < numRows; row++){
            for(int line = 0; row + line < s_len; line += cyclen){
                sb.append(s.charAt(row + line));
//                if(row != 0 && row != numRows - 1 && cyclen - row < s_len) {
//                    sb.append(s.charAt(cyclen - row));
                if(row != 0 && row != numRows - 1 && line + cyclen - row < s_len) {
                    sb.append(s.charAt(line + cyclen - row));
                }
            }
        }
        return sb.toString();
    }

//    按行排序
    public static String convert2(String s, int numRows) {
        if(numRows == 1) return s;
        int loc = 0;
        int len = Math.min(s.length(), numRows);
        String[] strs = new String[len];
//        不赋值ans中会出现null
        for(int i = 0; i < len; i++) strs[i] = "";
        boolean down = false;
        for(int i = 0; i < s.length(); i++){
            if(loc == 0 || loc == numRows - 1) {
                down = !down;
            }
            strs[loc] += s.charAt(i);
            loc  += down ? +1 : -1;
        }
        String ans = "";
        for(String row : strs){
            ans += row;
        }
        return ans;
    }
}