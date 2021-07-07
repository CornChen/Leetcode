package easy;

/** 3 的幂
 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

 示例 1：
 输入：n = 27
 输出：true

 提示：
 -231 <= n <= 231 - 1
 */
public class Lc326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(387420489));
    }
    public static boolean isPowerOfThree(int n) {
        // 漏掉n==1，及负数的提前筛选
        if(n < 1) return false;
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 0;
    }
}
