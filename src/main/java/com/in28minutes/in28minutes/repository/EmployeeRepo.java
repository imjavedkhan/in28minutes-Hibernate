package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.entity.Course;
import com.in28minutes.in28minutes.entity.Passport;
import com.in28minutes.in28minutes.entity.Student;
import com.in28minutes.in28minutes.entity.inheritance.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    //insert employee
    public void insertEmployee(Employee employee){
        entityManager.persist(employee);
    }

    // fetch emplyee

    public List<Employee> getAllEmployee(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

}
