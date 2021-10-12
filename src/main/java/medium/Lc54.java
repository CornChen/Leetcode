package medium;

import java.util.ArrayList;
import java.util.List;

/** 螺旋矩阵
 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 
 示例 1：
 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]

 示例 2：
 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 
 提示：
 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 10
 -100 <= matrix[i][j] <= 100
 */
public class Lc54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,},{3,4}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int lineLine = matrix.length, rowLen = matrix[0].length;
        int left = 0, right = rowLen - 1, top = 0, bottom = lineLine - 1;
        while (left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
//            for(int i = top; i < bottom; i++){
//            for(int i = top + 1; i < bottom; i++){
            for(int i = top + 1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            if(left < right && top < bottom){
//                for(int i = right; i > left; i--){
                for(int i = right - 1; i > left; i--){
                    res.add(matrix[bottom][i]);
                }
                for (int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
