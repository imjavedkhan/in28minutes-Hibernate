package com.in28minutes.in28minutes.entity.inheritance;

import com.in28minutes.in28minutes.entity.Course;
import com.in28minutes.in28minutes.entity.Passport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
