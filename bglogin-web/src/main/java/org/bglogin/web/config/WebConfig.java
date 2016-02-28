package org.bglogin.web.config;

import org.bglogin.services.config.ServicesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Class for Annotation Type Configuration
 * 
 * @author Giuseppe Vincenzi
 *
 */
@Configuration
@Import(ServicesConfig.class)
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "org.bglogin.web", "org.bglogin.services", "org.bglogin.model" })
public class WebConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getRequiredProperty("db.jdbcurl"), env.getRequiredProperty("db.username"),env.getRequiredProperty("db.password"));
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		return dataSource;
	}
}
