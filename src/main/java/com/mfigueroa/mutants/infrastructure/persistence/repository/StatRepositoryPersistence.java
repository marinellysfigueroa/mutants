package com.mfigueroa.mutants.infrastructure.persistence.repository;

import com.mfigueroa.mutants.domain.Stat;
import com.mfigueroa.mutants.domain.repository.StatRepository;
import com.mfigueroa.mutants.infrastructure.persistence.builder.StatBuilder;
import com.mfigueroa.mutants.infrastructure.persistence.entity.StatEntity;
import com.mfigueroa.mutants.infrastructure.persistence.repository.jpa.StatJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class StatRepositoryPersistence implements StatRepository, StatJpaRepository {

    private EntityManager entityManager;
    private static final String FIND_STAT = "Stat";


    public StatRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Stat getStat() {
        StatEntity statEntity = getStatEntity();
        return StatBuilder.convertToDomain(statEntity);
    }

    @Override
    public StatEntity getStatEntity() {
        StatEntity statEntity = null;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(StatEntity.class);
        Root root = cq.from(StatEntity.class);

        Query query = entityManager.createQuery(cq);

        try
        { statEntity=(StatEntity) query.getSingleResult();
        }catch (Exception e) {}

        return statEntity;
    }
}
