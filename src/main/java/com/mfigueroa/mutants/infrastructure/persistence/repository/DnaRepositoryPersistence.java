package com.mfigueroa.mutants.infrastructure.persistence.repository;

import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.domain.repository.DnaRepository;
import com.mfigueroa.mutants.infrastructure.persistence.builder.DnaBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DnaRepositoryPersistence implements DnaRepository {

    private EntityManager entityManager;

    public DnaRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public  void addDna(Dna dna){
        System.out.println(dna);
        entityManager.persist(DnaBuilder.convertToEntity(dna));
    }
}
