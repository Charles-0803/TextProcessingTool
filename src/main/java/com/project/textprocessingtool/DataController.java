package com.project.textprocessingtool;

import com.project.textprocessingtool.CustomData;
import com.project.textprocessingtool.DataManager;
import java.util.*;

public class DataController {
    private final DataManager<CustomData> dataManager = new DataManager<>();

    public void addData(String name, int id) {
        dataManager.addToList(new CustomData(name, id));
    }

    public void updateData(CustomData original, String newName, int newId) {
        List<CustomData> dataList = dataManager.getList();

        int index = dataList.indexOf(original);
        if (index != -1) {
            dataList.set(index, new CustomData(newName, newId));
        }
    }

    public void deleteData(CustomData data) {
        dataManager.removeFromList(data);
    }

    public CustomData getDataByNameAndId(String name, int id) {
        for (CustomData data : dataManager.getList()) {
            if (data.getName().equals(name) && data.getId() == id) {
                return data;
            }
        }
        return null;
    }

    public List<CustomData> getAllData() {
        return dataManager.getList();
    }
}

