package com.school.models;

public class Teacher {
    private int id;
    public static int count;

    public Teacher() {
        count++;
        id = count;
    }
}