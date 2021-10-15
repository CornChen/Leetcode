package medium;

import java.util.Arrays;

/** 螺旋矩阵 II
 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。

 示例 1：
 输入：n = 3
 输出：[[1,2,3],[8,9,4],[7,6,5]]

 示例 2：
 输入：n = 1
 输出：[[1]]

 提示：
 1 <= n <= 20
 */
public class Lc59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, left = 0, bottom = n, right = n;
        int add = 1;
        while (left < bottom && top < bottom){
            for(int i = left; i < right; i++){
                res[top][i]  = add++;
            }
            for(int i = top + 1; i < bottom; i++){
                res[i][right - 1] = add++;
            }
            for(int i = right - 2; i >= left; i--){
                res[bottom - 1][i] = add++;
            }
            for(int i = bottom - 2; i > top; i--){
                res[i][left] = add++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
