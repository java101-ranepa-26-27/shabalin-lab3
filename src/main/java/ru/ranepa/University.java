package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Student> students = new ArrayList<>();

    public Student addStudent(String name){
        Student student = Student.create(name);
        students.add(student);
        return student;
    }

    public void expelleStudent(long id){
        Student student = findStudentById(id);
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException(student.getName() + " уже отчислен или закончил обучение");
        }
        student.setState(State.DISMISSED);
    }

    public void transferToNextCourse(long id) {
        Student student = findStudentById(id);
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException(student.getName() + " уже отчислен или закончил обучение");
        }
        else if (student.average() <= 2.5) {
            System.out.println(student.getName() + " отчислен за плохую успеваемость");
            student.setState(State.DISMISSED);
        }
        else if(student.getCourse() == 4) {
            System.out.println(student.getName() + " Закончил обучение");
            student.setState(State.GRADUATED);

        }
        else{
            System.out.println(student.getName() + " Переведен на " + (student.getCourse() + 1) + " курс");
            student.setCourse(student.getCourse() + 1);
        }

    }

    public void addGrade(long id, int grade) {
        Student student = findStudentById(id);
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Нельзя ставить оценку отчисленному");
        }
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
        }
        student.addGrade(grade);
    }

    public void printSummary() {
        for(Student student : students){
            student.printReport();
        }
    }

    private Student findStudentById(long id){
        for (Student student : students) {
            if (student.getStudentID() == id) {
                return student;
            }
        }
        throw new IllegalArgumentException("Студент не найден");
    }
}