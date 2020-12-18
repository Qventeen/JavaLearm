package com.jr.level.level29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;

    private int age;
    private List<Student> students = new ArrayList<>();
    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double average) {
        Double tmp;
        for(Student s: students){
             tmp = s.getAverageGrade();
            if(tmp.equals(average)){
                return s;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max =  Double.MIN_VALUE;
        double max2 = max;
        Student max_student = null;
        for(Student s: students){
            max = Math.max(max,s.getAverageGrade());
            if(max2 < max){
                max2 = max;
                max_student = s;
            }
        }
        return max_student;
    }

    public Student getStudentWithMinAverageGrade() {
        double min =  Double.MAX_VALUE;
        double min2 = min;
        Student min_student = null;
        for(Student s: students){
            min = Math.min(min,s.getAverageGrade());
            if(min2 > min){
                min2 = min;
                min_student = s;
            }
        }

        return min_student;
    }

    public void expel(Student student){
        students.remove(student);
    }
}
