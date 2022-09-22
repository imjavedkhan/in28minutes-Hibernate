package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.In28minutesApplication;
import com.in28minutes.in28minutes.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= In28minutesApplication.class)
public class CourseRepoTest {

    @Autowired
    CourseRepo courseRepo;

    @Test
    public void testCourse(){
        Course course = courseRepo.findById(1001L);
        assertEquals("Hibernate", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteTest(){
        courseRepo.deleteById(1002L);
        assertNull(courseRepo.findById(1002L));
    }

    @Test
    public void testSave(){
        Course course = courseRepo.findById(1001L);
        course.setName("Boot");
        courseRepo.save(course);
        Course course1 = courseRepo.findById(1001L);
        assertEquals("Boot", course1.getName());
    }

}