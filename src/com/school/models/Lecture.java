package com.school.models;

public class Lecture extends Course {
    private HomeWork work;
    private AdditionalMaterial material;
    private static long count;
    private long courseID;
    private long personID;

    public Lecture(String name, long courseID) {
        super(name);
        this.courseID = courseID;
        count++;
    }

    public Lecture(String name, long courseID, long personID) {
        super(name);
        this.courseID = courseID;
        //add check for personID is a teacher
        this.personID = personID;
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
        String teacher = "";
        if (personID != 0) {
            teacher = "\n    ID викладача: " + personID;
        }
        return super.toString() + """
                                            
                        ID курсу: %d%s
                    """.formatted(courseID, teacher);
    }

    public static long getCount() {
        return count;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        //add check for existing personID and is a teacher
        this.personID = personID;
    }
}
