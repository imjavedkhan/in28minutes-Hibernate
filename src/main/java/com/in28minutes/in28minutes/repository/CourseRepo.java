package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.entity.Course;
import com.in28minutes.in28minutes.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    public void addReviewForCourse(Long id, List<Review> reviewList ) {

        //get the course 1003
        Course course = findById(id);
        logger.info("Course Review : {}", course.getReviewList());

        //add 2 review
        for(Review review : reviewList){
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }

        /*Review review1 = new Review("4","Good");
        Review review2 = new Review("5","Hats off");

        //add Relationship

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);*/

       /* //save it to database
        entityManager.persist(review1);
        entityManager.persist(review2);*/

    }
}
