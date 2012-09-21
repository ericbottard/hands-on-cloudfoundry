package org.cloudfoundry.samples.handson.ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.init.DatabasePopulatorUtils.execute;

@Configuration
public class Ex5Config {

    @Autowired
    @Qualifier("fromDataSource")
    private DataSource fromDataSource;

    /*
    @Bean
	public DataSource fromDataSource() {
        EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
        factory.setDatabaseName("hands-on-cf-persons");
        factory.setDatabaseType(H2);
        return factory.getDatabase();
	}
	*/

    @PostConstruct
    public void databasePopulator() {
        try {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("schema.sql", Ex5Config.class));
            execute(populator, fromDataSource);}
        catch(DataAccessResourceFailureException e) {
            //ignore
        }
    }

}
