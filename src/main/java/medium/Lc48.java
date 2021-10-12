package medium;

/** 旋转图像
 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

 示例 1：
 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[[7,4,1],[8,5,2],[9,6,3]]

 示例 2：
 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

 示例 3：
 输入：matrix = [[1]]
 输出：[[1]]

 示例 4：
 输入：matrix = [[1,2],[3,4]]
 输出：[[3,1],[4,2]]

 提示：
 matrix.length == n
 matrix[i].length == n
 1 <= n <= 20
 -1000 <= matrix[i][j] <= 1000
 */
public class Lc48 {
    public static void main(String[] args) {
        System.out.println(rotate(new int[][]{{1,2},{3,4}}));
    }

    public static int[][] rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int len =  matrix.length, tmp = 0;
        int[] arr = new int[len];
        // 沿左下到右上的对角线翻转一次
        for(int i = 0; i < len; i++){
//            for (int j = 0; j < i; j++){
            for (int j = 0; j < len - i - 1; j++){
                tmp = matrix[i][j];
//                matrix[i][j] = matrix[len - i - 1][len - j - 1];
//                matrix[len - i - 1][len - j - 1] = tmp;
                matrix[i][j] = matrix[len - j - 1][len - i - 1];
                matrix[len - j - 1][len - i - 1] = tmp;
            }
        }
        // 上下翻转一次即得逆时针旋转90度
//        for(int i = 0; i < len; i++){
        for(int i = 0; i < len / 2; i++){
            arr = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = arr;
        }
        return matrix;
    }
}
