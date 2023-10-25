package com.cms.config;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DbConfig {

	@Bean
	ObjectContext objectContext() {

		log.info("ACTION: Createing bean for ObjectContext");

		ServerRuntime cayenneRuntime = ServerRuntime.builder()
				.addConfig("cayenne-cms-01.xml")
				.build();

		return cayenneRuntime.newContext();
	}

}
