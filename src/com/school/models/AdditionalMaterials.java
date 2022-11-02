package com.school.models;

public class AdditionalMaterials {
    private int id;
    public static int count;

    public AdditionalMaterials() {
        count++;
        id = count;
    }
}
