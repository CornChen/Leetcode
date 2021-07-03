import java.util.ArrayList;
import java.util.List;

public class Lc257 {
    /** 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 示例:
     * 输入:
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */

    public static void main(String[] args) {
        System.out.println(binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPath(root, "", res);
        return res;
    }

    public static void constructPath(TreeNode root, String path, List<String> paths){
        if(root != null) {
            // StringBuilder sb = new StringBuilder();  未将path传递
            StringBuilder sb = new StringBuilder(path);
            // sb.append((Integer)root.val.toString);
            // sb.append(Integer.toString(root.val));
            sb.append(root.val);
            if (root.left == null && root.right == null){
                paths.add(sb.toString());
            } else {
                sb.append("->");
                constructPath(root.left, sb.toString(), paths);
                constructPath(root.right, sb.toString(), paths);
            }
        }
    }
}
