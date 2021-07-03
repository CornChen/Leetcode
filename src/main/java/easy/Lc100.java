package easy;

public class Lc100 {
    public static void main(String[] args) {
        System.out.println(isSameTree(
                new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)),
                new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null))));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(q == null || p.val != q.val){
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
