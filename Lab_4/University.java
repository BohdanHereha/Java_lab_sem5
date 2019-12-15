package com.company;

public class University {

    private  String name_of_university, name_of_faculties;
    private   int number_of_students, number_of_teachers;
    private   float percentage_of_fellows;

    public University(String name_of_university, String name_of_faculties, int  number_of_students,
                      int number_of_teachers, float percentage_of_fellows) {
        this.name_of_university = name_of_university;
        this.name_of_faculties = name_of_faculties;
        this. number_of_students =  number_of_students;
        this.number_of_teachers = number_of_teachers;
        this.percentage_of_fellows = percentage_of_fellows;
    }

    public float getPercentage() {
        return percentage_of_fellows;
    }

    public int getNumbStud() {
        return number_of_students;
    }

    public String getNameUiver() {return name_of_university;}

    public void printInfo() {
        System.out.println(ANSI_BLACK + "Name of the university: " +ANSI_RESET + name_of_university);
        System.out.println(ANSI_RED + "Name of the faculties: " + name_of_faculties + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Number of students: " + number_of_students + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Number of teachers: " + number_of_teachers + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Percentage of fellows: " + percentage_of_fellows + "%" +ANSI_RESET);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
}
