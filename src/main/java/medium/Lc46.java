package medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** 全排列
 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 
 示例 1：
 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 示例 2：
 输入：nums = [0,1]
 输出：[[0,1],[1,0]]

 示例 3：
 输入：nums = [1]
 输出：[[1]]

 提示：
 1 <= nums.length <= 6
 -10 <= nums[i] <= 10
 nums 中的所有整数 互不相同
 https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
public class Lc46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();
        for(int num : nums) output.add(num);
        backtrap(nums.length, output, res, 0);
        return res;
    }

    public static void backtrap(int n, List<Integer> output, List<List<Integer>> res, int start){
//        if(output.size() == n) res.add(output);
//        if(start == n) res.add(output);
        if(start == n) res.add(new ArrayList<Integer>(output));
        for(int i = start; i < n; i++){
            Collections.swap(output, start, i);
            backtrap(n, output, res, start + 1);
            Collections.swap(output, start, i);
        }
    }
}
