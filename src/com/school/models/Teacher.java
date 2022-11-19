package com.school.models;

public class Teacher {
    private int ID;
    public static int count;

    public Teacher() {
        count++;
        ID = count;
    }
}