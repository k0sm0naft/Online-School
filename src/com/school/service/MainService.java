package com.school.service;

import com.school.models.*;
import java.util.Scanner;

public class MainService {
    private static final Scanner userInput = new Scanner(System.in);
    private static int category;
    private static int branch;



    // Выбирает раздел
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

    //Выбор: создавать или отрыть существующий обьект
    private static void toCreateNewOne() {
        branch = 3;
        System.out.println("""
                Виберіть:
                1 - Створити новий об'єкт категорії.
                2 - Відкрити існуючий об'єкт категорії.""");
        int toCreate = userInput.nextInt();
        if (toCreate == 1) {
            creation();
        } else if (toCreate == 2) {
            //openObject()
        } else {
            ifWrongInput();
        }
    }

    //Показівает категорию вібора и направляет на следующую ветку
    private static void resultOfChoise() {
        branch = 2;
        switch (category) {
            case 1: //Курси
                System.out.println("Ви вибрали 'курси'");
                toCreateNewOne();
                break;
            case 2: //Вчителі
                System.out.println("Ви вибрали 'вчителі'");
                toCreateNewOne();
                break;
            case 3: //Студенти
                System.out.println("Ви вибрали 'студенти'");
                toCreateNewOne();
                break;
            case 4: //Лекції
                System.out.println("Ви вибрали 'лекції'");
                toCreateNewOne();
                break;
            case 5: //Вихід
                break;
            default: //Error
                branch = 1;
                ifWrongInput();
        }

    }

    //Ошибочный ввод запускает выбор выйти или попробывать еще
    private static void ifWrongInput() {
        System.out.println("""
                Категорії не інує, спробуваті ще?
                1 - Так
                2 - Ні""");
        int repeat = userInput.nextInt();
        if (repeat == 1) {
//Возвращает в последнее меню выбора
            switch (branch) {
                case 1:
                    choiseOfCategory();
                    break;
                case 2:
                    resultOfChoise();
                    break;
                case 3:
                    toCreateNewOne();
                    break;
                case 4:
                    creation();
                    break;
            }
        } else if (repeat == 2) {
            System.out.println("Ви закінчили роботу в программі");
        } else {ifWrongInput();}
    }

    private static void creation() {
        branch = 4;
        switch (category) {
            case 1://Создать обьект Курси
                System.out.println(111);
                break;
            case 2://Создать обьект Вчителі
                System.out.println(222);
                break;
            case 3://Создать обьект Студенті
                System.out.println(333);
                break;
            case 4://Создать обьект Лекції
                System.out.println("Введіть ID курсу до якого відноситься нова лекція");
                int ID = userInput.nextInt();
                System.out.println("ID курсу: #" + ID +"?");
                System.out.println("""
                        1 - Так
                        2 - Ні""");
                int saveID = userInput.nextInt();
                if (saveID == 1){
                    System.out.println("Введіть назву нової лекції");
                    String name = userInput.next();
                    System.out.println("Зберегти назву: '" + name +"'?");
                    System.out.println("""
                        1 - Так
                        2 - Ні""");
                    int saveName = userInput.nextInt();
                    if (saveName == 1){
                        new Lecture(name, ID);
                        System.out.println("Створена нова лекція '"+ name + "' в курсі з ID #" + ID);
                    }
                }
                System.out.println("Створено лекцій: " + Lecture.count);
                System.out.println("""
                        Створити нову?
                        1 - Так
                        2 - Повернутісь до вібору категорії""");
                int createOneMore = userInput.nextInt();
                if (createOneMore == 1){
                    creation();
                }else {choiseOfCategory();}
                break;
            default:
                ifWrongInput();
        }
    }
}
