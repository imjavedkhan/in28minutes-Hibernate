package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.entity.Passport;
import com.in28minutes.in28minutes.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepo {

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }

    public void deleteById(Long id){
        Student student  = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student student){
        if(student.getId()==null){
            entityManager.persist(student);
        }
        else {
            entityManager.merge(student);
        }
        return student;
    }

    public void saveStudentByPassportId(){

        Passport passport = new Passport("Z098643");
        entityManager.persist(passport);

        Student student1  = new Student("Hulk");
        student1.setPassport(passport);

        entityManager.persist(student1);
    }

}
