package com.ProyectoFinalBd2.ProyectoFinalBd2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

@Component
public class Neo4jConnectionTest implements CommandLineRunner {

    @Autowired
    private Neo4jClient neo4jClient;

    @Override
    public void run(String... args) throws Exception {
        String cypherQuery = "MATCH (n) RETURN count(n) AS nodeCount";
        neo4jClient.query(cypherQuery).fetchAs(Long.class).one()
            .ifPresent(count -> System.out.println("Number of nodes in Neo4j: " + count));
    }
}
