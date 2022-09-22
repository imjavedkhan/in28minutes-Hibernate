package com.in28minutes.in28minutes;

import com.in28minutes.in28minutes.entity.Course;
import com.in28minutes.in28minutes.entity.Review;
import com.in28minutes.in28minutes.repository.CourseRepo;
import com.in28minutes.in28minutes.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class In28minutesApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(In28minutesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//studentRepo.saveStudentByPassportId();

		Review review1 = new Review("4","Good");
		Review review2 = new Review("5","excellent work");

		List<Review> reviewList = new ArrayList<>();
		reviewList.add(review1);
		reviewList.add(review2);

		courseRepo.addReviewForCourse(1003L, reviewList);

		studentRepo.addStudentAndCourse();

	}
}
