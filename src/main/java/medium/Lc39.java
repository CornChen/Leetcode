package medium;

import java.util.*;

/**  组合总和
 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 对于给定的输入，保证和为target 的唯一组合数少于 150 个。

 示例1：
 输入: candidates = [2,3,6,7], target = 7
 输出: [[7],[2,2,3]]

 示例2：
 输入: candidates = [2,3,5], target = 8
 输出: [[2,2,2,2],[2,3,3],[3,5]]

 示例 3：
 输入: candidates = [2], target = 1
 输出: []

 示例 4：
 输入: candidates = [1], target = 1
 输出: [[1]]

 示例 5：
 输入: candidates = [1], target = 2
 输出: [[1,1]]

 提示：
 1 <= candidates.length <= 30
 1 <= candidates[i] <= 200
 candidate 中的每个元素都是独一无二的。
 1 <= target <= 500

 https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 */
public class Lc39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10,2,7,6,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) return res;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res){
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < len; i++){
            if(target - candidates[i] < 0) break;
            path.addLast(candidates[i]);
            dfs(candidates, i, len,target - candidates[i], path, res);
            path.removeLast();
        }
    }
}

