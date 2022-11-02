package com.school.models;

public class Lectures {
    private HomeWork work;
    private AdditionalMaterials material;
    private int id;
    public static int count;
    private String name;

    public Lectures(String lectureName) {
        count++;
        id = count;
        this.name = lectureName;
    }
}
