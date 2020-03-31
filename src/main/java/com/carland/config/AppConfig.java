package com.carland.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.carland")
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDataSource
			= new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		System.out.println(env.getProperty("jdbc.url"));
		

		setDatabaseConnection(securityDataSource);
		setPoolProperties(securityDataSource);
		
		
		return securityDataSource;
	}

	private void setDatabaseConnection(ComboPooledDataSource securityDataSource) {
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
	}

	private void setPoolProperties(ComboPooledDataSource securityDataSource) {
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
	}

	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

}
