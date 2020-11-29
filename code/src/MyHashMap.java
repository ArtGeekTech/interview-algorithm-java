import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyHashMap {

    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry>[] buckets;
    private int capacity = 16;
    private float loadFactor = 0.75f;
    private int size;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new List[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (size >= capacity * loadFactor) {
            rehash();
        }
        List<Entry> bucket = getBucket(key, buckets);
        Entry entry = getEntry(key, bucket);
        if (entry != null) {
            entry.value = value;
        } else {
            bucket.add(new Entry(key, value));
            size++;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        List<Entry> bucket = getBucket(key, buckets);
        Entry entry = getEntry(key, bucket);
        return entry == null ? -1 : entry.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        List<Entry> bucket = getBucket(key, buckets);
        if (bucket == null) {
            return;
        }

        ListIterator<Entry> iter = bucket.listIterator();
        while (iter.hasNext()) {
            Entry next = iter.next();
            if (next.key == key) {
                iter.remove();
                return;
            }
        }
    }

    private List<Entry> getBucket(int key, List<Entry>[] buckets) {
        int idx = hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<Entry>();
        }
        return buckets[idx];
    }

    private Entry getEntry(int key, List<Entry> bucket) {
        for (Entry entry: bucket) {
            if (entry.key == key) {
                return entry;
            }
        }
        return null;
    }

    private int hash(int key) {
        return Math.abs(key % capacity);
    }

    private void rehash() {
        capacity *= 2;
        List<Entry>[] newBuckets = new List[capacity];
        for (List<Entry> bucket: buckets) {
            if (bucket == null) {
                continue;
            }
            for (Entry entry: bucket) {
                getBucket(entry.key, newBuckets).add(entry);
            }
        }
        buckets = newBuckets;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */