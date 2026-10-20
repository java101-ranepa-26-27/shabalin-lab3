package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private static long id = 0;
    private final long studentID;
    private int course;
    private State state;
    private final List<Integer> grades;

    private Student(String name) {
        this.studentID = ++id;
        this.name = name;
        this.grades = new ArrayList<>();
        this.course = 1;
        this.state = State.ACTIVE;
    }

    public static Student create(String name) {
        return new Student(name);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double average() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setState(State state) {
        this.state = state;
    }

    private String report() {
        return "Студент: " + name + System.lineSeparator()
                + "Курс: " + course + System.lineSeparator()
                + "Состояние: " + state + System.lineSeparator()
                + "Оценки: " + grades + System.lineSeparator()
                + "Средний балл: " + average();
    }

    public void printReport() {
        System.out.println(report());
    }

    public int getCourse() {
        return course;
    }

    public State getState() {
        return state;
    }

    public long getStudentID() {
        return studentID;
    }
}