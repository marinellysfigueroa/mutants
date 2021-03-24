package com.mfigueroa.mutants.infrastructure.persistence.builder;

import com.mfigueroa.mutants.domain.Stat;
import com.mfigueroa.mutants.infrastructure.persistence.entity.StatEntity;

public class StatBuilder {

    public static Stat convertToDomain(StatEntity statEntity) {
        Stat stat = null;
        if (statEntity != null) {
            stat = new Stat(statEntity.getCountMutantDna(),statEntity.getCountHumanDna(),statEntity.getRatio());
        }
        return stat;
    }
}
