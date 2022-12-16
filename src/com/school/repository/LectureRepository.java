package com.school.repository;

import com.school.models.Lecture;

import java.util.Arrays;

public class LectureRepository {
    private static Lecture[] lecturesArray;
    private static final int STANDART_INIT_CAPACITY = 5;

    public LectureRepository() {
        this.lecturesArray = new Lecture[STANDART_INIT_CAPACITY];
    }

    /**
     * Change capacity of lectureArray
     */
    public LectureRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Помилка вводу при створенні стандартного розміру массиву");
            this.lecturesArray = new Lecture[STANDART_INIT_CAPACITY];
        } else {
            this.lecturesArray = new Lecture[inputCapacity];
        }
    }

    /**
     * Add new lecture to repository
     * @param lecture
     */
    public static void add(Lecture lecture) {

        int emptySlot = 0;
        for (int i = 0; i < lecturesArray.length; i++) {
            if (lecturesArray[i] == null & emptySlot == 0) {
                emptySlot = +1;
                lecturesArray[i] = lecture;
                break;
            }
        }
        if (emptySlot == 0) {
            int indexToAdd = lecturesArray.length;
            increaseCapacity();
            lecturesArray[indexToAdd] = lecture;
        }
    }

    /**
     * Method to increase capacity of lecture array
     */
    private static void increaseCapacity() {
        int newCapacity = (STANDART_INIT_CAPACITY * 3) / 2 + 1;
        Lecture[] tmpArr = new Lecture[newCapacity];
        System.arraycopy(lecturesArray, 0, tmpArr, 0, lecturesArray.length);
        lecturesArray = tmpArr;
    }

    /**
     *Return list of created lectures
     */
    public static String showCreatedLectures(){
        int j=0;
        int k=0;
        for (int i = 0; i < lecturesArray.length; i++){
            if (lecturesArray[i] == null)continue;
            j++;
        }
        String[] stringarr = new String[j];
        for (int i = 0; i < lecturesArray.length; i++){
            if (lecturesArray[i] == null) continue;
            stringarr[k] = lecturesArray[i].toString();
            k++;
        }
         return "Створені лекції: " + Arrays.toString(stringarr) + "\n";
    }
}
