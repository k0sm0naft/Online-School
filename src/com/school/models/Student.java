package com.school.models;

public class Student {
    private int ID;
    public static int count;

    public Student() {
        count++;
        ID = count;
    }
}
