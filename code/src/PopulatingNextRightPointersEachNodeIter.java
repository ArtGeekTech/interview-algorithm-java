public class PopulatingNextRightPointersEachNodeIter {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root, nextLevelStart = root.left;
        while (nextLevelStart != null) {
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            cur = nextLevelStart;
            nextLevelStart = cur.left;
        }
        return root;
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
