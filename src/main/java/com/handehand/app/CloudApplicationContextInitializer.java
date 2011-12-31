package com.handehand.app;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class CloudApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	private static final Logger logger = LoggerFactory.getLogger(CloudApplicationContextInitializer.class);
	
	public void initialize(ConfigurableApplicationContext applicationContext) {
        CloudEnvironment env = new CloudEnvironment();
        if (env.getInstanceInfo() != null) {
        	logger.info("cloud API: " + env.getCloudApiUri());
            applicationContext.getEnvironment().setActiveProfiles("cloud");
            
            String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
            for (String activeProfile : activeProfiles) {
            	logger.info("Active profile: " + activeProfile);
            }
        }
        else {
            applicationContext.getEnvironment().setActiveProfiles("default");
        }
    }
}