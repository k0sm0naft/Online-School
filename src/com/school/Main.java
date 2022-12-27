package com.school;

import com.school.models.*;
import com.school.repository.LectureRepository;
import com.school.service.LectureService;
import com.school.service.MainService;
public class Main {
    public static final Course firstCourse = new Course("Математичні дії");;

    public static void main(String[] args) {
        new LectureRepository();
        initData();
        MainService.choiseOfCategory();

//          Закоментированы, нужны для отладки:
        //System.out.println(Arrays.toString(Repository.getRepository()) + "\n" + "Размер массива: " + Repository.getRepository().length);
        //LectureRepository.getById(11, LectureRepository.getRepository());
        //LectureRepository.deleteById(1, LectureRepository.getRepository());
        //LectureService.showList(LectureRepository.getRepository());
        //System.out.println("\n" + "Размер массива лекций: " + LectureRepository.getRepository().length);
        //System.out.println(firstCourse.toString());
    }

    public static void initData() {
        LectureRepository.add(new Lecture("Додавання", firstCourse.getID()));
        LectureRepository.add(new Lecture("Віднімання", firstCourse.getID()));
        LectureRepository.add(new Lecture("Ділення", firstCourse.getID()));
        for ( int i = 4; i <=10; i++){
            LectureRepository.add(new Lecture("Лекція №"+i, 5));
        }
    }
}