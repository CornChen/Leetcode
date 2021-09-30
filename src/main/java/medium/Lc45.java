package medium;

/**  跳跃游戏 II
 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 假设你总是可以到达数组的最后一个位置。

 示例 1:
 输入: nums = [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。

 示例 2:
 输入: nums = [2,3,0,1,4]
 输出: 2

 提示:
 1 <= nums.length <= 104
 0 <= nums[i] <= 1000
 */
public class Lc45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static int jump2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0, curDis = 0, maxDis = 0;
        for(int i = 0; i < nums.length; i++) {
            maxDis = Math.max(maxDis, i + nums[i]);
            if(maxDis >= nums.length - 1){
                count++;
                break;
            }
            if(i == curDis) {
                curDis = maxDis;
                count++;
            }
        }
        return count;
    }
}
