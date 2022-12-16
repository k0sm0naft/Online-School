package com.school.service;

import com.school.Main;
import com.school.models.*;
import com.school.repository.*;

import java.util.Scanner;

public class MainService extends Main {
    private static final Scanner userInput = new Scanner(System.in);
    private static int category;
    private static int branch;

    /**
     * Choise of maine category
     */
    public static void choiseOfCategory() {
        System.out.println("""
                Вкажуть номер категорії:
                1 - Курси
                2 - Вчителі
                3 - Студенти
                4 - Лекції
                5 - Вихід з программи""");
        category = userInput.nextInt();
        resultOfChoise();
    }

    /**
     * Launch choise to create or open existed object
     */
    private static void toCreateOrOpen() {
        branch = 3;
        System.out.println("""
                Виберіть:
                1 - Створити новий об'єкт категорії.
                2 - Відкрити існуючі об'єкти категорії.""");
        int toCreate = userInput.nextInt();
        if (toCreate == 1) creation();
        else if (toCreate == 2) openObject();
        else ifWrongInput();
    }

    /**
     * Show category of choise and directs to the next branch
     */
    private static void resultOfChoise() {
        branch = 2;
        switch (category) {
            case 1: //Курси
                System.out.println("Ви вибрали 'курси'");
                toCreateOrOpen();
                break;
            case 2: //Вчителі
                System.out.println("Ви вибрали 'вчителі'");
                toCreateOrOpen();
                break;
            case 3: //Студенти
                System.out.println("Ви вибрали 'студенти'");
                toCreateOrOpen();
                break;
            case 4: //Лекції
                System.out.println("Ви вибрали 'лекції'");
                toCreateOrOpen();
                break;
            case 5: //Вихід
                userInput.close(); /**Где его лучше разместить?*/
                System.out.println("Программа закрита");
                break;
            default: //Error
                branch = 1;
                ifWrongInput();
        }

    }

    /**
     * Incorrect input triggers the choice to quit or try again
     */
    private static void ifWrongInput() {
        int repeat;
        do {
            System.out.println("""
                    Категорії не інує, спробуваті ще?
                    1 - Так
                    2 - Ні""");
            repeat = userInput.nextInt();
            if (repeat == 1) {
                switch (branch) { //Back to last opened menu
                    case 1:
                        choiseOfCategory();
                        break;
                    case 2:
                        resultOfChoise();
                        break;
                    case 3:
                        toCreateOrOpen();
                        break;
                    case 4:
                        creation();
                        break;
                    case 5:
                        openObject();
                        break;
                }
            }
        }
        while (repeat != 1 & repeat != 2);
        System.out.println("Ви закінчили роботу в программі");
    }

    /**
     * Create a new object of category
     */
    private static void creation() {
        branch = 4;
        switch (category) {
            case 1://Create object Course
                System.out.println("Розділ в розробці");
                choiseOfCategory();
                break;
            case 2://Create object Teacher
                System.out.println("Розділ в розробці");
                choiseOfCategory();
                break;
            case 3://Create object Student
                System.out.println("Розділ в розробці");
                choiseOfCategory();
                break;
            case 4://Create object Lecture
                /*добавить выбор курса к которому добавляетсья лекция.
                System.out.println("Введіть ID курсу до якого відноситься нова лекція");
                int ID = userInput.nextInt();
                System.out.println("ID курсу: #" + ID + "?");
                System.out.println("""
                        1 - Так
                        2 - Ні""");
                int saveID = userInput.nextInt();
                if (saveID == 1) {*/
                System.out.println("Введіть назву нової лекції");
                String name = userInput.next();
                System.out.println("Зберегти назву: '" + name + "'?");
                System.out.println("""
                        1 - Так
                        2 - Ні""");
                int saveName = userInput.nextInt();
                if (saveName == 1) {
                    LectureRepository.add(new Lecture(name, Main.firstCourse.ID));
                    System.out.println("Створена нова лекція '" + name + "' в курсі з ID #" + Main.firstCourse.ID + "\n");
                    System.out.println("Створено лекцій: " + Lecture.count + "\n");
                }
                /*}*/
                if (Lecture.count > 7) {
                    System.out.println("""                            
                            Створена максимальна кількість лекцій
                            Программа завершена""");
                    break;
                }
                System.out.println("""
                        Створити нову?
                        1 - Так
                        2 - Повернутісь до вібору категорії""");
                int createOneMore = userInput.nextInt();
                if (createOneMore == 1) creation();
                else choiseOfCategory();
                break;
            default:
                ifWrongInput();
        }
    }

    private static void openObject() {
        branch = 5;
        switch (category) {
            case 1://Open objects Course
                System.out.println("Розділ в розробці");
                choiseOfCategory();
                break;
            case 2://Open objects Teacher
                System.out.println("Розділ в розробці");
                choiseOfCategory();
                break;
            case 3://Open objects Student
                System.out.println("Розділ в розробці");
                choiseOfCategory();
                break;
            case 4://Create objects Lecture
                System.out.println(LectureRepository.showCreatedLectures());
                choiseOfCategory();
                break;
            default:
                ifWrongInput();
        }
    }
}