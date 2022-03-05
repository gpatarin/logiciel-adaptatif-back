package com.ynov.logicieladaptatif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
public class LogicielAdaptatifApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogicielAdaptatifApplication.class, args);
	}

}
