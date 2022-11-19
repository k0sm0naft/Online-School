package com.school.models;

public class AdditionalMaterial {
    private int ID;
    public static int count;

    public AdditionalMaterial() {
        count++;
        ID = count;
    }
}
