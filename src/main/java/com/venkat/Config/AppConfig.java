package com.venkat.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.venkat.DAO.UserDAOImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/venkat");
		datasource.setUsername("root");
		datasource.setPassword("admin");
		return datasource;
		
	}
	@Bean(name="DAOBean")
	public UserDAOImpl appDAO() {
		return new UserDAOImpl(getDataSource());
		
	}

}
