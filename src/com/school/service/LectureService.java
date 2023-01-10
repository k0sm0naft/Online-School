package com.school.service;

import com.school.Main;
import com.school.models.Lecture;
import com.school.repository.LectureRepository;
import java.util.Scanner;

public class LectureService {
    private static final Scanner userInput = new Scanner(System.in);

    public static void lectureCreation() {
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
        if (Lecture.getCount() > 7) {
            System.out.println("""                            
                    Створена максимальна кількість лекцій
                    Программа завершена""");
            System.exit(0);
        }

    }
}
