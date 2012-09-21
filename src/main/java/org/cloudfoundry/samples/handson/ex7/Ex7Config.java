package org.cloudfoundry.samples.handson.ex7;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

import static java.util.Arrays.asList;

@Configuration
//@ImportResource("classpath:context-ex7.xml")
public class Ex7Config {

    @Inject
    Environment environment;

    @PostConstruct
    public void foo() {
        System.out.println("GREPSUZETTE: " + asList(environment.getActiveProfiles()));
    }
	
	// Let's stop using @Configuration classes for a while
	// and use the <cloud: /> namespace in context-ex7.xml !

}
