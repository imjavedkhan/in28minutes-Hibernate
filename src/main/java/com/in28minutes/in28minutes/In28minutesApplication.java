package com.in28minutes.in28minutes;

import com.in28minutes.in28minutes.entity.Course;
import com.in28minutes.in28minutes.repository.CourseRepo;
import com.in28minutes.in28minutes.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		studentRepo.saveStudentByPassportId();

	}
}
