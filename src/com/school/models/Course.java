package com.school.models;

public class Course {
    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    private int ID;
    public static int count;
    private String name;

    public Course(String courseName) {
        count++;
        ID = count;
        this.name = courseName;
    }

    public int getID () {
        return ID;
    }
}
