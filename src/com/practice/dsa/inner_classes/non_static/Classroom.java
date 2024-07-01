package com.practice.dsa.inner_classes.non_static;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String className;
    private String teacherName;
    private List<Student> students;

    public Classroom(String className, String teacherName) {
        this.className = className;
        this.teacherName = teacherName;
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentName) {
        Student student = new Student(studentName);
        students.add(student);
        System.out.println("Student " + studentName + " added to " + className + " class.");
    }

    public void listStudents() {
        System.out.println("Students in "+className+" class.");
        for (Student student: students) {
            student.displayDetails();
        }
    }

    private class Student {
        private String studentName;

        public Student(String studentName) {
            this.studentName = studentName;
        }

        public void displayDetails() {
            System.out.println("Student Name: "+studentName+", class: "+className+", Teacher Name: "+teacherName);
        }
    }

    public static void main(String[] args) {
        Classroom classroom = new Classroom("BCS","Dube sir");
        classroom.addStudent("Alice");
        classroom.addStudent("Bob");

        classroom.listStudents();
    }
}
