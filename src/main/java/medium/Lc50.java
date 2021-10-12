package medium;

/** Pow(x, n)
 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
 
 示例 1：
 输入：x = 2.00000, n = 10
 输出：1024.00000

 示例 2：
 输入：x = 2.10000, n = 3
 输出：9.26100

 示例 3：
 输入：x = 2.00000, n = -2
 输出：0.25000
 解释：2-2 = 1/22 = 1/4 = 0.25

 提示：
 -100.0 <x< 100.0
 -231<= n <=231-1
 -104 <= xn <= 104
 */
public class Lc50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,-11));
    }

    public static double myPow(double x, int n) {
        return n > 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    public static double quickMul(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
