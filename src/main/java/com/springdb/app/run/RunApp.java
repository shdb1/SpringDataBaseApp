package com.springdb.app.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdb.app.config.ApplicationConfiguration;
import com.springdb.app.sevice.StudentService;

public class RunApp {

	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		StudentService studentService= (StudentService)applicationContext.getBean("studentservice");
		studentService.doStudentOperatios();
	}
}
