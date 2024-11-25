package com.project.textprocessingtool;

import java.util.*;

public class DataManager<T> {
    private final List<T> dataList = new ArrayList<>();
    private final Set<T> dataSet = new HashSet<>();
    private final Map<String, T> dataMap = new HashMap<>();

    public void addToList(T item) {
        dataList.add(item);
    }

    public void addToSet(T item) {
        dataSet.add(item);
    }

    public void addToMap(String key, T item) {
        dataMap.put(key, item);
    }

    public List<T> getList() {
        return new ArrayList<>(dataList);
    }

    public Set<T> getSet() {
        return new HashSet<>(dataSet);
    }

    public Map<String, T> getMap() {
        return new HashMap<>(dataMap);
    }

    public void removeFromList(T item) {
        dataList.remove(item);
    }

    public void removeFromSet(T item) {
        dataSet.remove(item);
    }

    public void removeFromMap(String key) {
        dataMap.remove(key);
    }
}
