package com.DesignPatterns.Creational.Builder;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int rollNo;
    // optional fields
    String emergencyPhoneNo;
    List<String>clubs;

    private Student(StudentBuilder sb) {
        this.name = sb.name;
        this.rollNo = sb.rollNo;
        this.emergencyPhoneNo = sb.emergencyPhoneNo;
        this.clubs = sb.clubs;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getEmergencyPhoneNo() {
        return emergencyPhoneNo;
    }

    public List<String> getClubs() {
        return clubs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", emergencyPhoneNo='" + emergencyPhoneNo + '\'' +
                ", clubs=" + clubs +
                '}';
    }

    public static class StudentBuilder{
        private String name;
        private int rollNo;
        // optional fields
        private String emergencyPhoneNo;
        private List<String>clubs;

        public StudentBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StudentBuilder setRollNo(int rollNo){
            this.rollNo = rollNo;
            return this;
        }

        public StudentBuilder setEmergencyNo(String emergencyPhoneNo){
            this.emergencyPhoneNo = emergencyPhoneNo;
            return this;
        }

        public StudentBuilder setClubs(List<String> clubs){
            this.clubs = clubs;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }


}
