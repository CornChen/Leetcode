//    Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode tree = new TreeNode(1,
                    new TreeNode(2, null, null),
                    new TreeNode(3, new TreeNode(4, new TreeNode(5,null, null), null), null));
}