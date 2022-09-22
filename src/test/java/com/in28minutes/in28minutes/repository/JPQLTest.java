package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.In28minutesApplication;
import com.in28minutes.in28minutes.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= In28minutesApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void testCourse(){
        List course = entityManager.createQuery("select c from Course c").getResultList();
        logger.info("Course - > {}",course);
    }


    @Test
    public void testCourse_bytypedQuery(){
        TypedQuery<Course> course = entityManager.createQuery("select c from Course c", Course.class);
        List<Course> courseList = course.getResultList();
        logger.info("Course - > {}",courseList);
    }
}