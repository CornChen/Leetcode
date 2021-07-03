package easy;

public class Lc111 {
    public static void main(String[] args) {
        System.out.println(minDepth(new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, new TreeNode(4, new TreeNode(5,null, null), null), null)
        )));
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
//        else if(root.right == null && root.left == null) return 1;
//        return 1 + Math.min(minDepth(root.left), minDepth(root.right));   只考虑了左右节点都不为空的情况，未考虑其中一个节点为空的情况
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        return (root.left == null || root.right == null) ? (m1 + m2 + 1) : (1 + Math.min(m1, m2));
    }
}
