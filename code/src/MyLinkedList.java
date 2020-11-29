public class MyLinkedList {

    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNodeAtIndex(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        linkBefore(new ListNode(val), head.next);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        linkBefore(new ListNode(val), tail);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        linkBefore(new ListNode(val), getNodeAtIndex(index));
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        unlink(getNodeAtIndex(index));
    }

    private ListNode getNodeAtIndex(int index) {
        ListNode node = head.next;
        while (index-- > 0) {
            node = node.next;
        }
        return node;
    }

    private void linkBefore(ListNode node, ListNode succ) {
        ListNode pred = succ.prev;
        pred.next = node;
        node.next = succ;
        succ.prev = node;
        node.prev = pred;
        size++;
    }

    private void unlink(ListNode node) {
        ListNode pred = node.prev, succ = node.next;
        pred.next = succ;
        succ.prev = pred;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
