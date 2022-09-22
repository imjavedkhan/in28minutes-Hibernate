package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.In28minutesApplication;
import com.in28minutes.in28minutes.entity.Passport;
import com.in28minutes.in28minutes.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= In28minutesApplication.class)
public class StudentRepoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Autowired
    StudentRepo studentRepo;


    ///uni directional one to one
    // we need Transactional here as we have used LAZY loading over passport in Student entity
    // so it will not run separate query to get passport data from database.
    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails(){
        Student student = studentRepo.findById(2001L);

        logger.info("Student details : {}", student);
        logger.info("Passport details : {}", student.getPassport());

    }

    //// bi-directional one to one
    // we dont need Transactional here as we have used EAGER loading over student in Passport entity
    // so it will not run separate query to get student data from database.
    @Test
    //@Transactional
    public void retrievePassportAndAssociatedStudentDetails(){
        Passport passport = entityManager.find(Passport.class,4003L);

        logger.info("Passport details : {}", passport);
        logger.info("Student details : {}", passport.getStudent());

    }

    @Test
    @Transactional
    public void someOpertion(){

        Student student =  studentRepo.findById(2001L);

        Passport passport = student.getPassport();

        passport.setNumber("M575723");

        student.setName("Avengers");

    }

}