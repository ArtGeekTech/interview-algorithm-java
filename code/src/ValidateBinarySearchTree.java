public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        return lower < root.val && root.val < upper && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}
