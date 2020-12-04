import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthNaryTree {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                Node cur = queue.poll();
                if (cur.children == null) {
                    continue;
                }
                for (Node child: cur.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }

        return depth;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
