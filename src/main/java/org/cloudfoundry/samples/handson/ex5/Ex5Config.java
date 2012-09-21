package org.cloudfoundry.samples.handson.ex5;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class Ex5Config {

	//@Bean
	public DataSource fromDataSource() {
		// TODO
		
		return null;
	}
	
	//@PostConstruct
	public void databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("schema.sql", Ex5Config.class));
		DatabasePopulatorUtils.execute(populator, fromDataSource());
	}

}
