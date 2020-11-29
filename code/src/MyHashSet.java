import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyHashSet {

    private List<Integer>[] buckets;
    private int cap = 256;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new List[cap];
    }

    public void add(int key) {
        if (!contains(key)) {
            getBucket(key, buckets).add(key);
        }
    }

    public void remove(int key) {
        List<Integer> bucket = getBucket(key, buckets);
        ListIterator<Integer> iter = bucket.listIterator();
        while (iter.hasNext()) {
            if (iter.next() == key) {
                iter.remove();
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        List<Integer> bucket = getBucket(key, buckets);
        for (int k: bucket) {
            if (k == key) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> getBucket(int key, List<Integer>[] buckets) {
        int idx = hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<>();
        }
        return buckets[idx];
    }

    private int hash(int key) {
        return Math.abs(key % cap);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
