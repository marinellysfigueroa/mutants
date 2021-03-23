package com.mfigueroa.mutants.infrastructure.persistence.builder;

import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.infrastructure.persistence.entity.DnaEntity;

public class DnaBuilder {
    public DnaBuilder() {
    }

    public static Dna convertToDomain(DnaEntity dnaEntity) {
        Dna dna = null;
        if (dnaEntity != null) {
            dna = new Dna(dnaEntity.getId(), dnaEntity.getDna(), dnaEntity.isMutant());
        }
        return dna;
    }

    public static DnaEntity convertToEntity(Dna dna) {
        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setId(dna.getId());
        dnaEntity.setDna(dna.getDna());
        dnaEntity.setMutant(dna.isMutant());
        return dnaEntity;
    }
}
