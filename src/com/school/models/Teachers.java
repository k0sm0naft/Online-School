package com.school.models;

public class Teachers {
    private int id;
    public static int count;

    public Teachers() {
        count++;
        id = count;
    }
}