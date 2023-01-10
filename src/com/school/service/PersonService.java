package com.school.service;

import com.school.Main;
import com.school.models.Lecture;
import com.school.models.Person;
import com.school.models.Role;
import com.school.repository.LectureRepository;
import com.school.repository.PersonRepository;

import java.util.Scanner;

public class PersonService {
    private static final Scanner userInput = new Scanner(System.in);

    public static void personCreation(Role role) {
        System.out.println("Введіть ПІБ");
        String name = userInput.next();
        System.out.println("Зберегти ПІБ: '" + name + "'?");
        System.out.println("""
                1 - Так
                2 - Ні""");
        int saveName = userInput.nextInt();
        if (saveName == 1) {
            LectureRepository.add(new Person(name, Main.firstCourse.getID(), role));
            System.out.println("Додано '" + name + "' в курс з ID #" + Main.firstCourse.getID() + "\n");
        }
    }

    public static void teacherToLecture() {
        System.out.println("Введіть ID вчыкладача:");
        long teacherID = userInput.nextInt();
        int teacherIndex = PersonRepository.getPersonById(teacherID, Role.TEACHER);
        if (teacherIndex != PersonRepository.getRepository().length) {
            Person teacher = (Person) PersonRepository.getRepository()[teacherIndex];
            if (teacher.getID() == teacherID) {
                System.out.println("Введіть ID лекції до якої додати викладача");
                long lectureID = userInput.nextInt();
                int lectureIndex = LectureRepository.getById(lectureID, LectureRepository.getRepository());
                if (lectureIndex != LectureRepository.getRepository().length) {
                    Lecture lecture = (Lecture) LectureRepository.getRepository()[lectureIndex];
                    if (lecture.getID() == lectureID) {
                        System.out.println("""
                                Додати вікладача до лекції?
                                1 - Так
                                2 - Повернутись до головного меню""");
                        int add = userInput.nextInt();
                        if (add == 1) {
                            lecture.setPersonID(teacherID);
                            System.out.println(lecture);
                            System.out.println(teacher);
                        }
                    }
                }
            }
        }
        MainService.choiseOfCategory();
    }
}
