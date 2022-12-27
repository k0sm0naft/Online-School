package com.school.models;

public class Lecture extends Course{
    private HomeWork work;
    private AdditionalMaterial material;
    private static long count;
    private long courseID;

    public Lecture(String name, long courseID) {
        super(name);
        this.courseID = courseID;
        count++;

    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        if (courseID > Course.getCount()) {
            System.out.println("ID не існує!");
        } else this.courseID = courseID;
    }
    @Override
    public String toString() {
        return super.toString() + """
                        
                            ID курсу: %d
                        """.formatted(courseID);
    }

    public static long getCount() {
        return count;
    }
}
