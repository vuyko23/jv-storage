package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static int size;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = new Object[MAX_ITEMS_NUMBER];
        valueArray = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keyArray[i]) || key == keyArray[i]) {
                valueArray[i] = value;
                return;
            }
        }
        checkArrayIndex();
        keyArray[size] = key;
        valueArray[size++] = value;
    }

    public void checkArrayIndex() {
        if (size >= MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Cant add new Element to Array");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (key == keyArray[i]) {
                    return (V) valueArray[i];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(keyArray[i])) {
                return (V) valueArray[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
