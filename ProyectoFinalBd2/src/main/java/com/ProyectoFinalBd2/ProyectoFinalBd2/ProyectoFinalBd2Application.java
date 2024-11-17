package com.ProyectoFinalBd2.ProyectoFinalBd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories")
@EnableMongoRepositories(basePackages = "com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories")

public class ProyectoFinalBd2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoFinalBd2Application.class, args);
    }
}
