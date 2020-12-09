public class PopulatingNextRightPointersEachNodeII {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root, nextLevelStart = getLeftmostChild(cur);
        while (nextLevelStart != null) {
            while (cur != null) {
                connectChildren(cur);
                Node nextNode = getFirstNodeWithChildren(cur.next);
                if (nextNode != null) {
                    getRightmostChild(cur).next = getLeftmostChild(nextNode);
                }
                cur = nextNode;
            }
            cur = getFirstNodeWithChildren(nextLevelStart);
            nextLevelStart = getLeftmostChild(cur);
        }
        return root;
    }

    private Node getLeftmostChild(Node node) {
        if (node == null) {
            return null;
        }
        return node.left != null ? node.left : node.right;
    }

    private Node getRightmostChild(Node node) {
        if (node == null) {
            return null;
        }
        return node.right != null ? node.right : node.left;
    }

    private void connectChildren(Node node) {
        if (node.left != null) {
            node.left.next = node.right;
        }
    }

    private Node getFirstNodeWithChildren(Node node) {
        while (node != null && node.left == null && node.right == null) {
            node = node.next;
        }
        return node;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
