package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {

    }

    public Student getStudentWithAverageGrade(double grade) {
        for(Student s : students){
            if(s.getAverageGrade() == grade)
                return s;
        }
        return null;
    }

    public Student getStudentWithHighestAverageGrade() {
        Student best = students.get(0);
        for(Student s : students)
            if (s.getAverageGrade() > best.getAverageGrade())
                best = s;

        return best;
    }

    public Student getStudentWithLowestAverageGrade() {
        Student worst = students.get(0);
        for(Student s : students)
            if (s.getAverageGrade() < worst.getAverageGrade())
                worst = s;

        return worst;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}