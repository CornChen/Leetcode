package easy;

public class Lc104 {
    public static void main(String[] args) {
        System.out.println(maxDepth(new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, new TreeNode(4, new TreeNode(5,null, null), null), null)
        )));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = 1 + maxDepth(root.left);
        int r = 1 + maxDepth(root.right);
        return Math.max(l, r);
    }
}
