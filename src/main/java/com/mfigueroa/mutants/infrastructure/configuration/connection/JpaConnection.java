package com.mfigueroa.mutants.infrastructure.configuration.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnection {

    private static String DNA = "dna";
    private static EntityManagerFactory entityManagerFactory;

    public JpaConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory(DNA);
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
