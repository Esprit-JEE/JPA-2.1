package com.esprit.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esprit.jpa.model.Student;
import com.esprit.jpa.service.StudentService;

public class Main {
    // create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("persistenceUnitName");
 
    static Logger logger = LoggerFactory.getLogger(Main.class);

    
    public static void main(String[] args) {
    	
        StudentService studentService = new StudentService(ENTITY_MANAGER_FACTORY);

    	logger.info("create Students");
    	studentService.create(1, "Asma", 22); 
        studentService.create(2, "Mohamed", 20); 
        studentService.create(3, "Tasnim", 25);

        logger.info("Update the age of Mohamed");
        studentService.upate(2, "Mohamed", 25);

        logger.info("Delete Asma");
        studentService.delete(1);

        logger.info("All students : ");
        List<Student> students = studentService.readAll();
        if (students != null) {
            for (Student stu : students) {
            	logger.info(stu.toString());
            }
        }

        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }


}