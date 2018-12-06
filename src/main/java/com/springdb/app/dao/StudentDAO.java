package com.springdb.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springdb.app.dos.StudentDO;
import com.springdb.app.rowmappers.StudentRowMapper;
 


@Service
public class StudentDAO {
	
	
	/* 
	 * 
	 * 
	 * select query for single object(row)- queryforobject
	 select query for multiple object then - query
	 update/delete/insert- update
	 
	 */
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean saveStudent() {
		
		return false;
	}

	
public StudentDO fetchSingleStudent() {
	String query = "select * from students limit 1";
	StudentDO studentDO =jdbcTemplate.queryForObject(query, new StudentRowMapper());
		return studentDO;
	}


public List<StudentDO> fetchStudents() {
	String query = "select * from students ";
	List<StudentDO> studentDOList =jdbcTemplate.query(query, new StudentRowMapper());
		return studentDOList;
	}


public void updateStudent() {
	String query = "update students set name='Ram1' where name='Ram' ";
	 jdbcTemplate.update(query);
	 
	}

public StudentDO fetchStudnetByNameAndAge(String name, int age) {
	String query = "select * from students where name=? and age=?";
	
	StudentDO studentDO =jdbcTemplate.queryForObject(query, new Object[] {name,age},new StudentRowMapper());
		return studentDO;
	}

}
