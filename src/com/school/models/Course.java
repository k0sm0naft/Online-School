package com.school.models;

public class Course {
    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public int ID;
    public static int count;
    public String name;

    public Course(String courseName) {
        count++;
        ID = count;
        this.name = courseName;
    }
}
