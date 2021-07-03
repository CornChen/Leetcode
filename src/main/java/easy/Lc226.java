package easy;

public class Lc226 {
    public static void main(String[] args) {
        System.out.println(invertTree(null));
    }

    /** 翻转二叉树
     * 示例：
     * 输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
