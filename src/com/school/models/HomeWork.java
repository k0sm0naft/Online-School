package com.school.models;

public class HomeWork {
    private static int id;
    public static int count;

    public HomeWork() {
        count++;
        id = count;
    }
}
