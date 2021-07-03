package easy;

public class Lc202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /** 快乐数
     编写一个算法来判断一个数 n 是不是快乐数。「快乐数」定义为：
     对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     如果 可以变为1，那么这个数就是快乐数。
     如果 n 是快乐数就返回 true ；不是，则返回 false 。

     示例 1：
     输入：19
     输出：true
     解释：
     1^2 + 9^2 = 82
     8^2 + 2^2 = 68
     6^2 + 8^2 = 100
     1^2 + 0^2 + 0^2 = 1

     示例 2：
     输入：n = 2
     4,16,37,58,
     输出：false

     提示：
     1 <= n <= 231 - 1
     */
    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
//            squareSum(slow);
//            squareSum(fast);
//            squareSum(fast);
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }while(slow != fast);
        return slow == 1;
    }

    public static int squareSum(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
}
