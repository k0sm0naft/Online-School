package com.school;

import com.school.models.*;
import com.school.repository.LectureRepository;
import com.school.service.MainService;

import java.util.Arrays;

public class Main {
    public static Course firstCourse;

    public static void main(String[] args) {
        new LectureRepository();
        initData();
        MainService.choiseOfCategory();
    }

    public static void initData() {
        firstCourse = new Course("Математичні дії");
        LectureRepository.add(new Lecture("Додавання", firstCourse.ID));
        LectureRepository.add(new Lecture("Віднімання", firstCourse.ID));
        LectureRepository.add(new Lecture("Ділення", firstCourse.ID));
    }
}