package com.DesignPatterns.Creational.Builder;

public class Main {
    public static void main(String[] args) {
        Student.StudentBuilder builder = new Student.StudentBuilder();
        Student s1 = builder.setName("Mike Ferguson").setEmergencyNo("12341223").setRollNo(22).build();
        System.out.println(s1);
    }
}
