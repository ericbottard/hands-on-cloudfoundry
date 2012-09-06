package org.cloudfoundry.samples.handson.ex5;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import static org.springframework.jdbc.datasource.init.DatabasePopulatorUtils.execute;

@Configuration
public class Ex5Config {

	@Bean
	public DataSource fromDataSource() {
        EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
        factory.setDatabaseName("hands-on-cf-persons");
        factory.setDatabaseType(H2);
        return factory.getDatabase();
	}
	
	@PostConstruct
	public void databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("schema.sql", Ex5Config.class));
		execute(populator, fromDataSource());
	}

}
