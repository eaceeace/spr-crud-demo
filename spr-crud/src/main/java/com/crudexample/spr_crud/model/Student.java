package com.crudexample.spr_crud.model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to automatically generate value
    private int rollNo;
    @Column(name="student_name")
    private String name;
    @Column(name="student_mark")
    private float percentage;
    public Student() {}
    public Student(float percentage, String name, String branch) {
        this.percentage = percentage;
        this.name = name;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                ", branch='" + branch + '\'' +
                '}';
    }

    @Column(name="student_branch")
    private String branch;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
