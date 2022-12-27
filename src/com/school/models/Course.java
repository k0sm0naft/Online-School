package com.school.models;

public class Course extends Model {
    private Teacher teacher;
    private Student student;
    private Lecture lecture;
    private static long count;

    public Course(String name) {
        super(name);
        count++;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Course.count = count;
    }
}
