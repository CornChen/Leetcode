package medium;

/** 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * 
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 * solution1： dp               O(n^2)
 * solution2：中心扩散法          O(n^2)
 * solution3：ManACher算法       O(n)
 * my solution：滑动窗口          O(n^3)
 */
public class Lc5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("cbbd"));
    }
//    my solution
    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int s_len = s.length();
        for(int max = s_len; max > 1; max--){
            for(int i = 0; i <= s_len - max; i++){
                String substring = s.substring(i, i + max);
                if(isPalindrome(substring)) return substring;
            }
        }
        return s.substring(0,1);
    }
    public static boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2 ; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

//  solution2：中心扩展
    public static String longestPalindrome2(String s) {
        if(s.length() < 2) return s;
        int start = 0, end = 0, max = 1;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > max){
//                start = i - len / 2;
//                end = i + (len + 1) / 2;
//                忘记更新max
                max = len;
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left , int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
//        return right - left + 1;
        return right - left - 1;
    }
}
