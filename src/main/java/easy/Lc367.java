package easy;
/** 有效的完全平方数
 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 进阶：不要 使用任何内置的库函数，如 sqrt 。
 
 示例 1：
 输入：num = 16
 输出：true

 示例 2：
 输入：num = 14
 输出：false
 
 提示：
 1 <= num <= 2^31 - 1
 */
public class Lc367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare2(16));
    }
    public static boolean isPerfectSquare(int num) {
        int x = 1;
        while(x <= (num + 1)/2){
            if(x * x == num) return true;
            x++;
        }
        return false;
    }

    // 牛顿迭代,yyds!
    public static boolean isPerfectSquare2(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while(x*x > num){
            x = (x + num / x)/2;
        }
        return x * x == num;
    }
}
