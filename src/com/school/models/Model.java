package com.school.models;

public class Model {
    private final long ID;
    private static long count;
    private String name;

    public Model(String name) {
        count++;
        ID = count;
        this.name = name;
    }

    @Override
    public String toString() {
        return  """
                 ID: %d
                     Назва: %s""".formatted(ID, name);
    }

    public long getID() {
        return ID;
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
