package ru.geekbrains.ntr_ads08;

import java.util.LinkedList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

    }

    private final LinkedList<Item<K, V>>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.data = new LinkedList[maxSize * 2];
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new LinkedList<>();
        } else {
            for (Item item : data[index]) {
                if (item.getKey().equals(key)) {
                    item.setValue(value);
                    return true;
                }
            }
        }
        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);

        if (data[index] == null) return null;

        for (Item item : data[index]) {
            if (item.getKey().equals(key)) {
                return (V)item.getValue();
            }
        }

        return  null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        if (data[index] == null) return null;

        for (Item item : data[index]) {
            if (item.getKey().equals(key)) {
                data[index].remove(item);

                if (data[index].size() == 0) {
                    data[index] = null;
                }
                size --;
                return (V)item.getValue();
            }
        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(" = ");
            if (data[i] == null) {
                sb.append("null");
            } else {
                for (int j = 0; j < data[i].size(); j++) {
                    sb.append(data[i].get(j));
                    if (j < data[i].size()-1) {
                        sb.append(", ");
                    }
                }
            }
            System.out.println(sb.toString());
        }
        System.out.println("----------");
    }
}
