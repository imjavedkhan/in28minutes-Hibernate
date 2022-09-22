package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepo {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course course  = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        if(course.getId()==null){
            entityManager.persist(course);
        }
        else {
            entityManager.merge(course);
        }
        return course;
    }

    public void playwithEnitityManager(){
        Course course1  = new Course("Java");
        entityManager.persist(course1);
        course1.setName("Java-Updated");

        Course course2  = new Course("CSS");
        entityManager.persist(course2);

        entityManager.detach(course2);

        course1.setName("CSS-Updated");



    }

}
