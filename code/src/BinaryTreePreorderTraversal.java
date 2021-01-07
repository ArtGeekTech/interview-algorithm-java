import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        preorder(root, rtn);
        return rtn;
    }

    private void preorder(TreeNode root, List<Integer> rtn) {
        if (root == null) return;
        rtn.add(root.val);
        preorder(root.left, rtn);
        preorder(root.right, rtn);
    }
}
