package com.school.repository;

import com.school.models.Lecture;
import com.school.models.Model;

public class LectureRepository extends Repository {
    private static Model[] lecturesArr;

    public LectureRepository() {
        this.lecturesArr = new Model[getSTANDARD_INIT_CAPACITY()];
    }


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

    public static void getById(long ID) {
        int i = 0;
        for (Model lecture : lecturesArr) {
            i++;
            if (lecture == null)continue;
            if (ID == lecture.getID()) {
                System.out.println(lecture.toString());
            }
        }
        if (i == lecturesArr.length) System.out.println("Об'єкта з ID №" + ID + " не існує");
    }

    public static void deleteById(long ID) {
        for (int i = 0; i <= lecturesArr.length; i++) {
            if (i == lecturesArr.length) {
                System.out.println("ID не існує.");
                break;
            }
            if (lecturesArr[i] == null)continue;
            if (ID == lecturesArr[i].getID()) {
                lecturesArr[i] = null;
                break;
            }
        }
    }
}
