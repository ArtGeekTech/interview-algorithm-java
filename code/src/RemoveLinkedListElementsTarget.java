public class RemoveLinkedListElementsTarget {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(), cur = dummy;
        dummy.next = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
