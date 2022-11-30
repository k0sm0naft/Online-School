package com.school;

import com.school.models.*;
import com.school.service.MainService;

public class Main {

    public static void main(String[] args) {

        Course firstCourse = new Course("Математичні дії");
        Lecture firstLecture = new Lecture("Додавання", firstCourse.ID);
        Lecture secondLecture = new Lecture("Віднімання", firstCourse.ID);
        Lecture thirdLecture = new Lecture("Ділення", firstCourse.ID);
        Lecture forthLecture = new Lecture("Множення", firstCourse.ID);
        Lecture fifthLecture = new Lecture("Відсотки", firstCourse.ID);
        Lecture sixthLecture = new Lecture("Корені", firstCourse.ID);

        MainService.choiseOfCategory();
    }
}
