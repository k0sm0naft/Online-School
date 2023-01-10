package com.school;

import com.school.models.*;
import static com.school.repository.LectureRepository.add;
import static com.school.repository.PersonRepository.add;
import static com.school.service.MainService.choiseOfCategory;

public class Main {
    public static final Course firstCourse = new Course("Математичні дії");;

    public static void main(String[] args) {
        initData();
        choiseOfCategory();
    }

    private static void initData() {
        add(new Lecture("Додавання", firstCourse.getID(), 5));
        add(new Lecture("Віднімання", firstCourse.getID()));
        add(new Lecture("Ділення", firstCourse.getID()));
        add(new Person("Some teacher", firstCourse.getID(), Role.TEACHER));
        add(new Person("Second teacher", firstCourse.getID(), Role.STUDENT));
        for ( int i = 4; i <=10; i++){
            add(new Lecture("Лекція №"+i, 1));
        }
    }
}