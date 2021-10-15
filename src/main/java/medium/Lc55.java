package medium;

/** 跳跃游戏
 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。

 示例1：
 输入：nums = [2,3,1,1,4]
 输出：true
 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

 示例2：
 输入：nums = [3,2,1,0,4]
 输出：false
 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

 提示：
 1 <= nums.length <= 3 * 104
 0 <= nums[i] <= 105
 */
public class Lc55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
//        后续循环从1开始，未考虑nums[0]==0时的情况（当nums.length == 1 时，返回true）
        if(nums[0] == 0 && nums.length > 1) return false;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
//            dp[i] = Math.max(i + nums[i], dp[i - 1] - 1);
            dp[i] = Math.max(nums[i], dp[i - 1] - 1);
//            if(dp[i] + i >= len - 1) return true;
//            if(dp[i] == 0) return false;
//            if(dp[i] <= i) return false;
//            if(dp[i] <= i && i != len - 1) return false;
            if(dp[i] <= 0 && i != len - 1) return false;
        }
        return true;
    }
}
