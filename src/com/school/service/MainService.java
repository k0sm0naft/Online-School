package com.school.service;

import com.school.repository.*;

import java.util.Scanner;

public class MainService {
    private static final Scanner userInput = new Scanner(System.in);
    private static int category;
    private static int branch;

    private static void inDev() {
        System.out.println("Розділ в розробці");
    }

    /**
     * Choise of maine category
     */
    public static void choiseOfCategory() {
        System.out.println("""
                Вкажіть номер категорії:
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
                2 - Відкрити існуючі об'єкти категорії.
                3 - Відкрити об'єкт категорії за ID.
                4 - Видалити об'єкт категорії за ID.
                5 - Повернутись до головного меню.""");
        int toCreate = userInput.nextInt();
        switch (toCreate) {
            case 1 -> creation();
            case 2 -> openAllObject();
            case 3 -> openObject();
            case 4 -> deleteObject();
            case 5 -> choiseOfCategory();
            default -> ifWrongInput();
        }
    }

    private static void deleteObject() {
        System.out.println("Введіть ID об'єкта для видалення");
        long delete = userInput.nextLong();
        switch (category) {
            case 1://delete object Course
            case 3://delete object Student
            case 2://delete object Teacher
                inDev();
                break;
            case 4://delete object Lecture
                LectureRepository.deleteById(delete);
                break;
        }
        toCreateOrOpen();
    }

    private static void openObject() {
        System.out.println("Введіть ID об'єкта:");
        long open = userInput.nextLong();
        switch (category) {
            case 1://open object Course
            case 3://open object Student
            case 2://open object Teacher
                inDev();
                break;
            case 4://Create object Lecture
                LectureRepository.getById(open);
                break;
        }
        toCreateOrOpen();
    }

    /**
     * Show category of choise and directs to the next branch
     */
    private static void resultOfChoise() {
        branch = 2;
        switch (category) {
            case 1: //Курси
                System.out.println("Ви вибрали 'курси'");
                break;
            case 2: //Вчителі
                System.out.println("Ви вибрали 'вчителі'");
                break;
            case 3: //Студенти
                System.out.println("Ви вибрали 'студенти'");
                break;
            case 4: //Лекції
                System.out.println("Ви вибрали 'лекції'");
                break;
            case 5: //Вихід
                userInput.close(); /**Где его лучше разместить?*/
                System.out.println("Программа закрита");
                System.exit(0);
                break;
            default: //Error
                branch = 1;
                ifWrongInput();
        }
        toCreateOrOpen();
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
                    2 - Ні (Вихід)""");
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
                        openAllObject();
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
            case 3://Create object Student
            case 2://Create object Teacher
                inDev();
                break;
            case 4://Create object Lecture
                LectureService.lectureCreation();
                break;
            default:
                ifWrongInput();
        }
        toCreateOrOpen();
    }

    private static void openAllObject() {
        branch = 5;
        switch (category) {
            case 1://Open all objects Course
            case 2://Open all objects Teacher
            case 3://Open all objects Student
                inDev();
                break;
            case 4://Create all objects Lecture
                System.out.println(LectureService.showList(LectureRepository.getRepository()));
                break;
            default:
                ifWrongInput();
        }
        toCreateOrOpen();
    }
}