package com.school.models;

public class Courses {
    private Teachers teacher;
    private Students student;
    private Lectures lecture;

    private int id;
    public static int count;

    public Courses() {
        count++;
        id = count;
    }
}
