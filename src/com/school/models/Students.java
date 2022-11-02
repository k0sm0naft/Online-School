package com.school.models;

public class Students {
    private int id;
    public static int count;

    public Students() {
        count++;
        id = count;
    }
}
