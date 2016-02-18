package org.bglogin.services.config;

import org.bglogin.model.config.ModelConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Class for Annotation Type Configuration
 * @author Giuseppe Vincenzi
 *
 */
@Configuration
@Import(ModelConfig.class)
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "org.bglogin.model" })
@Profile("production")
public class ServicesConfig {

}
