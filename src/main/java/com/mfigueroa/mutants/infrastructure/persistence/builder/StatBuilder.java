package com.mfigueroa.mutants.infrastructure.persistence.builder;

import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.domain.Stat;
import com.mfigueroa.mutants.infrastructure.persistence.entity.DnaEntity;
import com.mfigueroa.mutants.infrastructure.persistence.entity.StatEntity;

public class StatBuilder {
    public StatBuilder() {
    }

    public static Stat convertToDomain(StatEntity statEntity) {
        Stat stat = null;
        if (statEntity != null) {
            stat = new Stat(statEntity.getCountMutantDna(),statEntity.getCountHumanDna());
        }
        return stat;
    }

    public static StatEntity convertToEntity(Stat stat) {
        StatEntity statEntity = new StatEntity();
        statEntity.setCountMutantDna(stat.getCountMutantDna());
        statEntity.setCountHumanDna(stat.getCountHumanDna());
        statEntity.setRatio(stat.getRatio());
        return statEntity;
    }
}
