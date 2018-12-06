package com.springdb.app.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springdb.app.dos.StudentDO;

public class StudentRowMapper implements RowMapper<StudentDO>{

	@Override
	public StudentDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("current ro is:"+rowNum);
		StudentDO studentDO = new StudentDO();
		studentDO.setName(rs.getString("name"));
		studentDO.setAge(rs.getInt("age"));
		studentDO.setAddress(rs.getString("address"));
		return studentDO;
	}

}
