package com.school.repository;

import com.school.models.Lecture;
import com.school.models.Model;

public class LectureRepository extends Repository {
    private static Model[] lecturesArr = new Model[getSTANDART_INIT_CAPACITY()];;

    /**
     * Add new lecture to repository
     */
    public static void add(Lecture lecture) {
        for (int i = 0; i <= lecturesArr.length; i++) {
            if (i == lecturesArr.length) increaseCapacity();
            if (lecturesArr[i] == null) break;
        }
        add(lecture, lecturesArr);
    }

    public static Model[] increaseCapacity() {
        return lecturesArr = increaseCapacity(lecturesArr);
    }

    public static Model[] getRepository() {
        return lecturesArr;
    }
}
