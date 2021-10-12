package medium;

import java.lang.reflect.Array;
import java.util.*;

/** 全排列 II
 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 示例 1：
 输入：nums = [1,1,2]
 输出：
 [[1,1,2],[1,2,1],[2,1,1]]

 示例 2：
 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
 提示：
 1 <= nums.length <= 8
 -10 <= nums[i] <= 10
 */
public class Lc47 {
    private static Boolean[] vis;

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 3}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        vis = new Boolean[nums.length];
        backtrap(nums, res, 0, output);
        return res;
    }

    public static void backtrap(int[] nums, List<List<Integer>> res, int idx, List<Integer> output) {
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (Boolean.TRUE.equals(vis[i]) || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            output.add(nums[i]);
            vis[i] = true;
            backtrap(nums, res, idx + 1, output);
            vis[i] = false;
            output.remove(idx);
        }
    }
}
