package collections;

import java.util.*;

public class MyHash<K,V> {

    private Set<HashEntry<K,V>>[] elements;

    private int hashSize;

    private int elementsInHash;

    private double load ;

    @SuppressWarnings("unchecked")
    public MyHash(int hashSize) {
        this.hashSize = hashSize;
        elements = (Set<HashEntry<K,V>>[]) new Set[hashSize];
        elementsInHash = 0;
        load = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new HashSet<>();
        }
    }

    public void insert(K key,V value) {
        elementsInHash = elementsInHash + 1;

        load = elementsInHash/(hashSize*1.0);

        Set<HashEntry<K, V>> set = elements[key.hashCode() % elements.length];

        set.add(new HashEntry<>(key, value));

        if (load >= 0.7) {
            reload();
        }

    }

    @SuppressWarnings("unchecked")
    private void reload() {
        List<HashEntry<K, V>> entries = new ArrayList<>();

        for (Set<HashEntry<K, V>> list : elements) {
            entries.addAll(list);
        }

        hashSize = hashSize * 2;
        elementsInHash = 0;
        elements = new Set[hashSize];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = new HashSet<>();
        }

        for (HashEntry<K, V> entry : entries) {
            insert(entry.getKey(),entry.getValue());
        }
    }

    public void remove(K key) {
        elements[key.hashCode() % elements.length].remove(new HashEntry<>(key, null));
    }

    public V get(K key) {
        Set<HashEntry<K, V>> entries = elements[key.hashCode() % elements.length];
        for (HashEntry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    private static class HashEntry<K,V>{
        private final K key;
        private final V value;

        private HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HashEntry<?,?>)) return false;
            HashEntry<?, ?> hashEntry = (HashEntry<?, ?>) o;
            return Objects.equals(getKey(), hashEntry.getKey());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getKey());
        }
    }
}
