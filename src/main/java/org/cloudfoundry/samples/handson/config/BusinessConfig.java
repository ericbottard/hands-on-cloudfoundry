package org.cloudfoundry.samples.handson.config;

import org.cloudfoundry.samples.handson.ex4.Ex4Config;
import org.cloudfoundry.samples.handson.ex5.Ex5Config;
import org.cloudfoundry.samples.handson.ex6.Ex6Config;
import org.cloudfoundry.samples.handson.ex7.Ex7Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Ex4Config.class, Ex5Config.class, Ex6Config.class, Ex7Config.class})
public class BusinessConfig {

}
