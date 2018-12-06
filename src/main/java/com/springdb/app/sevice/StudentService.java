package com.springdb.app.sevice;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springdb.app.dao.StudentDAO;
import com.springdb.app.dos.StudentDO;

@Service("studentservice")
public class StudentService {
	@Autowired
	StudentDAO studentDAO;

public StudentService() {
	
	System.out.println("i am being executed");
}
	public void doStudentOperatios(){
		System.out.println("Gonna Make DB callll!!!!!!!!!!!");
		StudentDO studentDO = studentDAO.fetchSingleStudent();
		System.out.println("Respose !!!!!!!!!!");
		System.out.println(studentDO);
		
		System.out.println("Gonna Make DB callll!!!!!!!!!!!");
		List<StudentDO> studentDOList = studentDAO.fetchStudents();
		System.out.println("Respose !!!!!!!!!!");
		System.out.println(studentDOList);
		
		System.out.println("gonna update");
		studentDAO.updateStudent();
		
		System.out.println("Gonna Make DB callll!!!!!!!!!!!");
		List<StudentDO> studentDOList1 = studentDAO.fetchStudents();
		System.out.println("Respose !!!!!!!!!!");
		System.out.println(studentDOList1);
		
		StudentDO studentDOByNameAndAge =studentDAO.fetchStudnetByNameAndAge("John", 21);
		System.out.println(studentDOByNameAndAge);
	}
	

}
