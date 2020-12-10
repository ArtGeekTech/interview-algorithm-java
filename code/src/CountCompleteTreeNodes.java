public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getHeight(root.left), rh = getHeight(root.right);
        if (lh == rh) {
            return 1 + (1 << lh) - 1 + countNodes(root.right);
        } else if (lh == rh + 1) {
            return 1 + countNodes(root.left) + (1 << rh) - 1;
        } else {
            throw new IllegalArgumentException("Not Valid CBT");
        }
    }

    private int getHeight(TreeNode cur) {
        int h = 0;
        while (cur != null) {
            cur = cur.left;
            h++;
        }
        return h;
    }
}
