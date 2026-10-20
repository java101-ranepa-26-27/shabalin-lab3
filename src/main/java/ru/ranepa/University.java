package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public Student addStudent(String name){
        Student student = Student.create(name);
        students.add(student);
        System.out.println("Student added to University");
        return student;
    }

    public Student expelleStudent(long id){
        Student student = findStudentById(id);
        if(student == null) {
            throw new IllegalArgumentException("Student " + id + " not found");
        }
        // Проверка: если уже отчислен или выпустился
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент уже отчислен или закончил");
        }
        student.setState(State.DISMISSED);
        return student;
    }

    public void transferToNextCourse(long id) {
        Student student = findStudentById(id);
        if(student == null) {
            throw new IllegalArgumentException("Student " + id + " not found");
        }
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент уже отчислен или закончил");
        }
        if (student.average() <= 2.5) {
            System.out.println("Студент " + student.getName() + " отчислен: средний балл " + student.average());
            student.setState(State.DISMISSED);
            return;
        }
        if (student.getCourse() == 4) {
            student.setState(State.GRADUATED);
            return;
        }
        student.setCourse(student.getCourse() + 1);
    }

    public void addGrade(long id, int grade) {
        Student student = findStudentById(id);
        if(student == null) {
            throw new IllegalArgumentException("Student " + id + " not found");
        }
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Нельзя ставить оценку отчисленному");
        }
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
        }
        student.addGrade(grade);
    }

    public String printSummary() {
        StringBuilder sb = new StringBuilder("=== Сводка ===\n");
        for (Student s : students) {
            sb.append(s.toString()).append("\n");
        }
        String result = sb.toString();
        System.out.print(result);
        return result;
    }

    private Student findStudentById(long id){
        for (Student student : students) {
            if (student.getStudentID() == id) {
                return student;
            }
        }
        return null;
    }
}