package org.cloudfoundry.samples.handson.ex6;

import org.cloudfoundry.samples.handson.ex5.Ex5Config;
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
public class Ex6Config {

    @Autowired
    @Qualifier("toDataSource")
    private DataSource toDataSource;

/*
    @Bean
    public DataSource toDataSource() {
        EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
        factory.setDatabaseName("hands-on-cf-person-copies");
        factory.setDatabaseType(H2);
        return factory.getDatabase();
    }
*/

    @PostConstruct
    public void databasePopulator() {
        try {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("schema.sql", Ex5Config.class));
            execute(populator, toDataSource);
        }
        catch(DataAccessResourceFailureException e) {
            //ignore
        }
    }
}
