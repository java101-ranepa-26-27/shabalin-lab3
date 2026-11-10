package ru.ranepa;

public class Main {

    public static void main(String[] args) {
        University university = new University();
        Student student = university.addStudent("Иванов Иван");
        student.getGrades().add(4);
        student.getGrades().add(5);
        university.transferToNextCourse(student.getStudentID());

        Student student1 = university.addStudent("Сергеев Сергей");
        student1.getGrades().add(2);
        student1.setCourse(3);
        university.transferToNextCourse(student1.getStudentID());

        Student student2 = university.addStudent("Алексеев Алексей");
        student2.getGrades().add(4);
        student2.setCourse(4);
        university.transferToNextCourse(student2.getStudentID());


        try {
            university.expelleStudent(student1.getStudentID());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

        university.printSummary();
        // TODO: создать университет
        // TODO: зачислить 2–3 студентов и поставить оценки
        // TODO: перевести студента со средним баллом больше 2.5
        // TODO: перевести студента со средним баллом 2.5 или меньше
        // TODO: перевести студента с 4 курса
        // TODO: отчислить студента и показать отказ
        // TODO: [вариант N] — выполнить свой кейс, строки начинать с [вариант N]
        // TODO: напечатать сводку — в ней должна быть информация из кейса
    }
}
