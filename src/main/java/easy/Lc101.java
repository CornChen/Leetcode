package easy;

public class Lc101 {
    public static void main(String[] args) {
        System.out.println(isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        )));
    }

    public static boolean isSymmetric(TreeNode root){
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) &&
                isMirror(t1.left, t2.right) &&
                isMirror(t1.right, t2.left);
    }
}
