import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(5000000));
    }

    /** 计数质数
     统计所有小于非负整数n的质数的数量。

     示例 1：
     输入：n = 10
     输出：4
     解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

     示例 2：
     输入：n = 0
     输出：0

     示例 3：
     输入：n = 1
     输出：0

     */
    public static int countPrimes(int n) {
        List<Integer> prime = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){
//                prime.add(isPrime[i]);
                prime.add(i);
            }
//            for(int j = 0; j < isPrime.length && i * prime[j] < n; j++){
            for (int j = 0; j < prime.size() && i * prime.get(j) < n; j++) {
//                忘记筛除合数
                isPrime[i * prime.get(j)] = 0;
                if(i % prime.get(j) == 0) break;
            }
        }
        return prime.size();
    }
}
