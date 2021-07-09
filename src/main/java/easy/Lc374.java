package easy;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

/** 猜数字大小
 猜数字游戏的规则如下：
 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：

 -1：我选出的数字比你猜的数字小 pick < num
 1：我选出的数字比你猜的数字大 pick > num
 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 返回我选出的数字。
 */
public class Lc374 {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    public static int guess(int num){
        int pick = 2;
        return Integer.compare(pick, num);
    }

    public static int guessNumber(int n) {
//        return midGuess(0, n); 会导致n==1时死循环
        return midGuess(1, n);
    }

    public static int midGuess(int left, int right){
//        int mid = (left + right) / 2; int型会溢出
        int mid = left + (right - left) / 2;
        if(guess(mid) == 0) return mid;
        else if(guess(mid) == -1) {
        // return midGuess(left, mid) 会产生死循环
             return midGuess(left, mid - 1);
        }
        // return midGuess(mid, right);
        else return midGuess(mid + 1, right);
    }
}
