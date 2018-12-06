package com.springdb.app.dbconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:db.properties")
public class DataBaseConfigurator {
	
	@Autowired
	Environment environment;
	
	
private DataSource getDataSource() {
	
	//DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, username, password)
	DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
/*	driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
	driverManagerDataSource.setUsername("postgres");
	driverManagerDataSource.setPassword("soft123");*/

	driverManagerDataSource.setUrl(environment.getProperty("database.url"));
	driverManagerDataSource.setUsername(environment.getProperty("database.uname"));
	driverManagerDataSource.setPassword(environment.getProperty("database.password"));
	
	return driverManagerDataSource;
}

@Bean
public JdbcTemplate getJdbcTemplate() {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	jdbcTemplate.setDataSource(getDataSource());
	return jdbcTemplate;
}

}
