package com.school;

import com.school.models.*;

public class Main {
    public static void main(String[] args) {
        Lecture lecture1 = new Lecture("Додавання");
        Lecture lecture2 = new Lecture("Віднімання");
        Lecture lecture3 = new Lecture("Ділення");
        Lecture lecture4 = new Lecture("Множення");

        System.out.println(Lecture.count);
    }
}