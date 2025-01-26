package com.Demo;

class Student implements Comparable<Student>{
    int rollNo;
    String name;
    public Student(int rollNo, String name){
        System.out.println("Student constructor called !! ");
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}

public class Compare {
    public static void main(String[] args) {
        Student s1 = new Student(1, "rishi");
        Student s2 = new Student(4, "ritik");
        System.out.println(s1 == s2);
    }
}
