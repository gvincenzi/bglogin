package org.bglogin.web.config.test;

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
@ComponentScan(basePackages = { "org.bglogin.model", "org.bglogin.services", "org.bglogin.web.controller" })
@Profile("test")
public class TestWebConfig {
	@Bean
	public EmbeddedDatabase dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL)
			.addScript("classpath:sql/test/web_init_datatables.sql")
			.addScript("classpath:sql/test/web_init_data.sql")
			.build();
		return db;
	}

}
