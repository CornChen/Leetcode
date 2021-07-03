public class Lc172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
    }

    /** 阶乘后的零
     给定一个整数 n，返回 n! 结果尾数中零的数量。
     示例 1:
     输入: 3
     输出: 0

     解释:3! = 6, 尾数中没有零。
     示例2:

     输入: 5
     输出: 1
     解释:5! = 120, 尾数中有 1 个零.
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
            count += n/5;
            n /= 5;
        }
        return count;
//        for(int i = 0; i <= n; i++){
//            int tmp = i;
//            while(tmp > 0 && tmp % 5 == 0){
//                count++;
//                tmp /= 5;
//            }
//        }
//        return count;
    }
}
