public class RemoveDuplicatesSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(), cur = dummy;
        dummy.next = head;

        while (cur != null) {
            if (cur.next != null && cur.next.next != null
                    && cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
