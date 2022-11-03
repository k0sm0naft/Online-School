package com.school.models;

public class AdditionalMaterial {
    private int id;
    public static int count;

    public AdditionalMaterial() {
        count++;
        id = count;
    }
}
