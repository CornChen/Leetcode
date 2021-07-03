public class Lc258 {
    /** 各位相加
     给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

     示例:
     输入: 38
     输出: 2
     解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于2 是一位数，所以返回 2。
     */
    public static void main(String[] args) {
        System.out.println(addDigits(2345));
    }

    public static int addDigits(int num) {
        /** 骚气解法
         * x*100+y*10+z=x*99+y*9+x+y+z
         * 这个公式可得 ‘num’ 和 “各位相加的结果” 模9同余，即num%9。(num-1)%9+1把取值范围从0到8变成9，1，2，3，4，5，6，7，8了。（0换成了9）
         * https://leetcode-cn.com/problems/add-digits/solution/java-o1jie-fa-de-ge-ren-li-jie-by-liveforexperienc/
         */
        return (num - 1) % 9 + 1;
    }
}
