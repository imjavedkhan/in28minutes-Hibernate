package com.in28minutes.in28minutes.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    //bi-directional - we use mappedBy and value will be owning side variable name so passport is non owning
    // side
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "passport")
    private Student student;


    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport" +
                "{" +
                "id=" + id +
                ", name='" + number + '\'' +
                '}';
    }
}
