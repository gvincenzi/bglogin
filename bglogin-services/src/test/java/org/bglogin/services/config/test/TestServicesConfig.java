package org.bglogin.services.config.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Class for Annotation Type Configuration
 * @author Giuseppe Vincenzi
 *
 */
@Configuration
@ComponentScan(basePackages = { "org.bglogin.model", "org.bglogin.services" })
@Profile("test")
public class TestServicesConfig {
	@Bean
	public EmbeddedDatabase dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL)
			.addScript("classpath:sql/test/login_init_datatables.sql")
			.addScript("classpath:sql/test/login_init_data.sql")
			.build();
		return db;
	}

}
