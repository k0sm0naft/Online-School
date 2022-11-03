package com.school.models;

public class Course {
    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    private int id;
    public static int count;

    public Course() {
        count++;
        id = count;
    }
}
