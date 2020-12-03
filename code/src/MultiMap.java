import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MultiMap<K, V> {

    static class Entry<K, V> {
        K key;
        List<V> values;

        public Entry(K key, V value) {
            this.key = key;
            addValue(value);
        }

        public Entry(K key, List<V> values) {
            this.key = key;
            this.values = values;
        }

        public void addValue(V value) {
            if (this.values == null) {
                this.values = new ArrayList<>();
            }
            this.values.add(value);
        }
    }

    private static final float LOAD_FACTOR = 0.75f;
    private List<Entry<K, V>>[] buckets;
    private int capacity;
    private int size;

    public MultiMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new List[this.capacity];
    }

    public MultiMap() {
        this(4);
    }

    public void put(K key, V value) {
        List<Entry<K, V>> bucket = getBucket(key, buckets);
        Entry<K, V> entry = getEntry(key, bucket);
        if (entry != null) {
            entry.addValue(value);
        } else {
            bucket.add(new Entry<>(key, value));
            size++;
            if (size >= capacity * LOAD_FACTOR) {
                rehash();
            }
        }
    }

    public List<V> get(K key) {
        List<Entry<K, V>> bucket = getBucket(key, buckets);
        Entry<K, V> entry = getEntry(key, bucket);
        return entry == null ? null : entry.values;
    }

    public boolean remove(K key) {
        List<Entry<K, V>> bucket = getBucket(key, buckets);
        ListIterator<Entry<K, V>> iter = bucket.listIterator();
        while (iter.hasNext()) {
            Entry<K, V> entry = iter.next();
            // Objects.equals(entry.key, key)
            if (entry.key == null ? key == null : entry.key.equals(key)) {
                iter.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    private void rehash() {
        this.capacity *= 2;
        List<Entry<K, V>>[] newBuckets = new List[this.capacity];
        for (List<Entry<K, V>> bucket: buckets) {
            if (bucket == null) {
                continue;
            }
            for (Entry<K, V> entry: bucket) {
                getBucket(entry.key, newBuckets).add(new Entry<>(entry.key, entry.values));
            }
        }
        this.buckets = newBuckets;
    }

    private int hash(K key) {
        return Math.abs((key == null ? 0 : key.hashCode()) % capacity);
    }

    private List<Entry<K,V>> getBucket(K key, List<Entry<K,V>>[] buckets) {
        int idx = hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<>();
        }
        return buckets[idx];
    }

    private Entry<K,V> getEntry(K key, List<Entry<K,V>> bucket) {
        for (Entry<K, V> entry: bucket) {
            if ((entry.key == key) || (entry.key != null && entry.key.equals(key))) {
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] keys = {"abcdefghijk", "hot", "hot", "dog", "hot", "log", "dog", null, "", null};
        Integer[] vals = {1, 23, 4, 5, 6, 7, 8, null, 0, 0};
        MultiMap<String, Integer> multiMap = new MultiMap<>();

        multiMap.put(null, -1);
        System.out.println(multiMap.get(null));

        for (int i = 0; i < keys.length; i++) {
            multiMap.put(keys[i], vals[i]);
            System.out.print(i + ": ");
            System.out.println(multiMap.get(keys[i]));
        }

        String key1 = "hot";
        System.out.println(multiMap.remove(key1));
        System.out.println(multiMap.get(key1) == null);
        System.out.println(!multiMap.remove(key1));

        String key2 = null;
        System.out.println(multiMap.remove(key2));
        System.out.println(multiMap.get(key2) == null);
        System.out.println(!multiMap.remove(key2));

        for (int i = 0; i < keys.length; i++) {
            multiMap.put(keys[i], vals[i]);
            System.out.print(i + ": ");
            System.out.println(multiMap.get(keys[i]));
        }
    }
}
