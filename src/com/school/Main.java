package com.school;

import com.school.models.*;

public class Main {
    public static void main(String[] args) {
        Lectures Lecture1 = new Lectures("Додавання");
        Lectures Lecture2 = new Lectures("Віднімання");
        Lectures Lecture3 = new Lectures("Ділення");

        System.out.println(Lectures.count);
    }
}