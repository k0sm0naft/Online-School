package com.school.models;

public class Lecture {
    private HomeWork work;
    private AdditionalMaterial material;
    private int ID;
    public static int count;
    private String name;
    public int courseID;

    public Lecture(String lectureName, int courseID) {
        count++;
        ID = count;
        this.name = lectureName;
        this.courseID = courseID;
    }
}
