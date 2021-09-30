package medium;

import java.sql.Statement;
import java.util.*;

/** 组合总和 II
 * 给定一个数组'candidates'和一个目标数'target'，找出'candidates'中所有可以使数字和为'target'的组合。
 * candidates'中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。'
 *
 * 示例'1:
 * 输入: candidates ='[10,1,2,7,6,1,5], target ='8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例'2:
 * 输入: candidates ='[2,5,2,1,2], target ='5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * 提示:
 * 1 <='candidates.length <= 100
 * 1 <='candidates[i] <= 50
 * 1 <= target <= 30
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
public class Lc40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if(len == 0) return res;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, len, path, res);
        return res;
    }

    private static void dfs(int[] candidates, int begin, int target, int len, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < len; i++){
            if(target - candidates[i] < 0) break;
//            剪掉同层级相同值的枝
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            path.addLast(candidates[i]);
//            dfs(candidates, i, target - candidates[i], len, path, res);
            dfs(candidates, i + 1, target - candidates[i], len, path, res);
            path.removeLast();
        }
    }
}
