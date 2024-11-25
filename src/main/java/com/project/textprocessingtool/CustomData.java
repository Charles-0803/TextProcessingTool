package com.project.textprocessingtool;

import java.util.Objects;


public class CustomData {
    private final String name;
    private final int id;

    public CustomData(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Getter for the id
    public int getId() {
        return id;
    }

    // Override equals to compare objects based on name and id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If the objects reference the same memory, they are equal
        if (o == null || getClass() != o.getClass()) return false; // Ensure the class types match
        CustomData that = (CustomData) o;
        return id == that.id && Objects.equals(name, that.name); // Compare fields
    }

    // Override hashCode to generate a consistent hash based on name and id
    @Override
    public int hashCode() {
        return Objects.hash(name, id); // Generate hash using name and id
    }

    // Override toString for a meaningful representation in UI
    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}



