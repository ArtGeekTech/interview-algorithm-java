import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTreeBFS {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                // when found the first leaf node, also the nearest
                if (cur.left == null && cur.right == null) {
                    return depth + 1;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
