package com.school;

import com.school.models.*;
import com.school.repository.LectureRepository;
import com.school.service.LectureService;
import com.school.service.MainService;

import java.util.Arrays;

public class Main {
    public static Course firstCourse;

    public static void main(String[] args) {
        new LectureRepository();
        initData();
        MainService.choiseOfCategory();
        //System.out.println(Arrays.toString(Repository.getRepository()) + "\n" + "Размер массива: " + Repository.getRepository().length);
        //LectureRepository.getById(4);
        //LectureRepository.deleteById(9);
        //System.out.println(LectureService.showList(LectureRepository.getRepository()) + "\n" + "Размер массива лекций: " + LectureRepository.getRepository().length);
    }

    public static void initData() {
        firstCourse = new Course("Математичні дії");
        LectureRepository.add(new Lecture("Додавання", firstCourse.getID()));
        LectureRepository.add(new Lecture("Віднімання", firstCourse.getID()));
        LectureRepository.add(new Lecture("Ділення", firstCourse.getID()));
        for ( int i = 4; i <=10; i++){
            LectureRepository.add(new Lecture("Лекція №"+i, 1));
        }
    }
}