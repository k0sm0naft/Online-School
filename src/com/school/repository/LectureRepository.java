package com.school.repository;

import com.school.models.Lecture;
import com.school.models.Model;

public class LectureRepository extends Repository {
    private static Lecture[] lecturesArr;

    public LectureRepository() {
        this.lecturesArr = new Lecture[getSTANDARD_INIT_CAPACITY()];
    }

    /**
     * Add new lecture to repository
     */
    public static void add(Lecture lecture) {
        add(lecture, lecturesArr);
    }

    public static Lecture[] getLecturesArr() {
        return lecturesArr;
    }
}
