package com.mfigueroa.mutants.infrastructure.persistence.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;
import java.io.Serializable;

@Entity()
@Immutable
@Subselect("select uuid() as id,count_human_dna, count_mutant_dna, (case when count_human_dna <>0 then (count_mutant_dna/count_human_dna) else 0 end) as ratio from (select count (distinct dna) as count_human_dna from dna where is_mutant = false) as human\n" +
        "join (select count (distinct dna) as count_mutant_dna from dna where is_mutant = true) as mutant")
@Synchronize({"Dna"})
public class StatEntity implements Serializable {

    @Id
    private String id;
    @Column()
    private Long countMutantDna;
    @Column()
    private Long countHumanDna;
    @Column()
    private double ratio;

    public Long getCountMutantDna() {
        return countMutantDna;
    }

    public Long getCountHumanDna() {
        return countHumanDna;
    }

    public double getRatio() {
        return ratio;
    }
}
