import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversalIter {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        helper(root, rtn);
        return rtn;
    }

    private void helper(TreeNode root, List<Integer> rtn) {
        if (root == null) return;
        rtn.add(root.val);
        helper(root.left, rtn);
        helper(root.right, rtn);
    }
}
