package com.school.service;

import com.school.Main;
import com.school.models.Lecture;
import com.school.models.Model;
import com.school.repository.LectureRepository;

import java.util.Arrays;
import java.util.Scanner;

public class LectureService {
    private static final Scanner userInput = new Scanner(System.in);

    public static void lectureCreation() {
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
            LectureRepository.add(new Lecture(name, Main.firstCourse.getID()));
            System.out.println("Створена нова лекція '" + name + "' в курсі з ID #" + Main.firstCourse.getID() + "\n");
            System.out.println("Створено лекцій: " + Lecture.getCount() + "\n");
        }
        /*}*/
        if (Lecture.getCount() > 7) {
            System.out.println("""                            
                    Створена максимальна кількість лекцій
                    Программа завершена""");
        }

    }

    /**
     * Return list of created objects
     */
    public static String showList(Model[] repository) {
        int capacityStringArr = 0;
        for (int i = 0; i < repository.length; i++) {
            if (repository[i] == null) continue;
            capacityStringArr++;
        }
        String[] stringArr = new String[capacityStringArr];
        int i = 0;
        for (Model model : repository) {
            if (model == null) continue;
            stringArr[i] = model.toString();
            i++;
        }
        return "\n" + stringArr.length + " створених об'єктів : " + Arrays.toString(stringArr) + "\n";
    }
}
