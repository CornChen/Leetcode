package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 */
public class Lc40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target) return res;
        int len = 0;
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] > target) {
                if (i > 1) len = i - 1;
                else return res;
            } else if (candidates[i] == target) {
                List<Integer> tar = new ArrayList<>(target);
                len = i - 1;
                if (!res.contains(tar)) {
                    res.add(tar);
                }
            }
        }

        int left = 0, right = len - 1;
        while (left < right){
            List<Integer> tmp = new ArrayList<>();
            if(candidates[left] + candidates[right] == target) {
                tmp.add(left);
                tmp.add(right);
            }
        }

        return res;
    }
}
