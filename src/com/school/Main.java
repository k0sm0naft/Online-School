package com.school;

import com.school.models.*;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Математичні дії");
        Lecture lecture1 = new Lecture("Додавання", course1.getID());
        Lecture lecture2 = new Lecture("Віднімання", course1.getID());
        Lecture lecture3 = new Lecture("Ділення", course1.getID());
        Lecture lecture4 = new Lecture("Множення", course1.getID());
        Lecture lecture5 = new Lecture("Відсотки", course1.getID());
        Lecture lecture6 = new Lecture("Корені", course1.getID());

        System.out.println("ID курсу лекції 'Корені' - " + lecture6.courseID);
        System.out.println("Кількість створених лекцій - " + Lecture.count);
    }
}