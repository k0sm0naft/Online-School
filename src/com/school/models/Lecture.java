package com.school.models;

public class Lecture {
    private HomeWork work;
    private AdditionalMaterial material;
    private int id;
    public static int count;
    private String name;

    public Lecture(String lectureName) {
        count++;
        id = count;
        this.name = lectureName;
    }
}
