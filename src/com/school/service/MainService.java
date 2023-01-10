package com.school.service;

import com.school.models.Model;
import com.school.models.Role;
import com.school.repository.*;

import java.util.Scanner;

public class MainService {
    private static final Scanner userInput = new Scanner(System.in);
    private static int category;
    private static int branch;

    private MainService() {
    }

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
        if (category == 2) System.out.println("6 - Додати викладача до лекції");
        int toCreate = userInput.nextInt();
        switch (toCreate) {
            case 1 -> creation();
            case 2 -> openAllObject();
            case 3 -> openObject();
            case 4 -> deleteObject();
            case 5 -> choiseOfCategory();
            case 6 -> {
                if (category == 2) PersonService.teacherToLecture();
                else ifWrongInput();
            }
            default -> ifWrongInput();
        }
    }

    private static void deleteObject() {
        System.out.println("Введіть ID об'єкта для видалення");
        long delete = userInput.nextLong();
        switch (category) {
            case 1://delete object Course
                inDev();
                break;
            case 2://delete object Teacher
                PersonRepository.deleteById(delete,Role.TEACHER);
                break;
            case 3://delete object Student
                PersonRepository.deleteById(delete,Role.STUDENT);
                break;
            case 4://delete object Lecture
                LectureRepository.deleteById(delete, LectureRepository.getRepository());
                break;
            default:
                System.out.println("error");
        }
        toCreateOrOpen();
    }

    private static void openObject() {
        System.out.println("Введіть ID об'єкта:");
        long open = userInput.nextLong();
        switch (category) {
            case 1://open object Course
                inDev();
                break;
            case 2://open object Teacher
                PersonRepository.getPersonById(open,Role.TEACHER);
                break;
            case 3://open object Student
                PersonRepository.getPersonById(open,Role.STUDENT);
                break;
            case 4://open object Lecture
                LectureRepository.getById(open, LectureRepository.getRepository());

                break;
            default:
                System.out.println("error");
        }
        toCreateOrOpen();
    }

    /**
     * Show category of choise and directs to the next branch
     */
    private static void resultOfChoise() {
        branch = 2;
        switch (category) {
            case 1 -> System.out.println("Ви вибрали 'курси'");
            case 2 -> System.out.println("Ви вибрали 'вчителі'");
            case 3 -> System.out.println("Ви вибрали 'студенти'");
            case 4 -> System.out.println("Ви вибрали 'лекції'");
            case 5 -> {
                userInput.close(); /**Где его лучше разместить?*/
                System.out.println("Программа закрита");
                System.exit(0);
            }
            default -> {
                branch = 1;
                ifWrongInput();
            }
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
                    case 1 -> choiseOfCategory();
                    case 2 -> resultOfChoise();
                    case 3 -> toCreateOrOpen();
                    case 4 -> creation();
                    case 5 -> openAllObject();
                    default -> System.out.println("error");
                }
            }
        }
        while (repeat != 1 && repeat != 2);
        System.out.println("Ви закінчили роботу в программі");
    }

    /**
     * Create a new object of category
     */
    private static void creation() {
        branch = 4;
        switch (category) {
            case 1://Create object Course
                inDev();
                break;
            case 2://Create object Teacher
                PersonService.personCreation(Role.TEACHER);
                break;
            case 3://Create object Student
                PersonService.personCreation(Role.STUDENT);
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
                System.out.println("Викладачі");
                showList(PersonRepository.getPersonByRole(Role.TEACHER));
                break;
            case 3://Open all objects Student
                System.out.println("Студенти");
                showList(PersonRepository.getPersonByRole(Role.STUDENT));
                break;
            case 4://Open all objects Lecture
                System.out.println("Лекції");
                showList(LectureRepository.getRepository());
                break;
            default:
                ifWrongInput();
        }
        toCreateOrOpen();
    }

    /**
     * Return list of created objects
     */
    private static void showList(Model[] repository) {
        int count = 0;
        for (Model obj : repository) {
            if (obj == null) continue;
            System.out.println(obj);
            count++;
        }
        System.out.println("~~~Створенио об'єктів: " + count + "~~~");
    }
}