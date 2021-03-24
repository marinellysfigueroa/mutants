package com.mfigueroa.mutants.testdatabuilder;

import com.mfigueroa.mutants.application.command.StatCommand;
import com.mfigueroa.mutants.domain.Stat;

public class StatTestDataBuilder {

    private static final Long DEFAULT_COUNT_MUTANT_DNA= Long.valueOf(0);
    private static final Long DEFAULT_COUNT_HUMAN_DNA= Long.valueOf(0);
    private static final double DEFAULT_RATIO=0.0;

    private Long countMutantDna;
    private Long countHumanDna;
    private double ratio;

    public StatTestDataBuilder() {
        this.countHumanDna = DEFAULT_COUNT_HUMAN_DNA;
        this.countMutantDna = DEFAULT_COUNT_MUTANT_DNA;
        this.ratio = DEFAULT_RATIO;
    }

    public Stat build() {
        return new Stat(this.countMutantDna,this.countHumanDna,this.ratio);
    }

    public StatCommand buildCommand() {
        return new StatCommand(this.countMutantDna,this.countHumanDna,this.ratio);
    }
}
