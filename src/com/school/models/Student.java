package com.school.models;

public class Student {
    private int id;
    public static int count;

    public Student() {
        count++;
        id = count;
    }
}
