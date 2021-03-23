package com.mfigueroa.mutants.infrastructure.configuration.system;

import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.domain.repository.DnaRepository;
import com.mfigueroa.mutants.domain.repository.StatRepository;
import com.mfigueroa.mutants.infrastructure.configuration.connection.JpaConnection;
import com.mfigueroa.mutants.infrastructure.persistence.repository.DnaRepositoryPersistence;
import com.mfigueroa.mutants.infrastructure.persistence.repository.StatRepositoryPersistence;

import javax.persistence.EntityManager;

public class PersistenceSystem {
    private EntityManager entityManager;

    public PersistenceSystem(EntityManager entityManager) {
        this.entityManager = new JpaConnection().createEntityManager();
    }

    public StatRepository getStat()  {
        return new StatRepositoryPersistence(entityManager);
    }


    public void start() {
        entityManager.getTransaction().begin();
    }

    public void finish() {
        entityManager.getTransaction().commit();
    }
}
