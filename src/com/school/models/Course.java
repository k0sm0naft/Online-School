package com.school.models;

public class Course extends Model {
    private Person person;
    private Lecture lecture;
    private static long count;

    public Course(String name) {
        super(name);
        count++;
    }

    public static long getCount() {
        return count;
    }
}
