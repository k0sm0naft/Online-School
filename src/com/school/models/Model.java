package com.school.models;

public class Model {
    private long ID;
    private static long count;
    private String name;

    public Model(String name) {
        count++;
        ID = count;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n" + "ID: " + ID + "\n    " + "Назва: " + name + "\n    ";
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Model.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
