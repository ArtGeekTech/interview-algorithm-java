import static agt.algo.Utils.ListNode;

public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int newCap = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[newCap];
        for (ListNode head: hashTable) {
            ListNode cur = head;
            while (cur != null) {
                add(newHashTable, hashcode(cur.val, newCap), cur.val);
                cur = cur.next;
            }
        }
        return newHashTable;
    }

    private void add(ListNode[] tbl, int idx, int val) {
        if (tbl[idx] == null) {
            tbl[idx] = new ListNode(val);
            return;
        }
        ListNode cur = tbl[idx];
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        return;
    }

    private int hashcode(int key, int cap) {
        return (key % cap + cap) % cap;  // to handle negative number
    }
}
