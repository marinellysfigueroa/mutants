package com.mfigueroa.mutants.testdatabuilder;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.domain.Dna;

public class MutantDnaTestDataBuilder {
    private static final String[] MUTANT_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGC",
            "CCCCTA",
            "TCACTG"
    };
    private String dna[];

    public MutantDnaTestDataBuilder() {
        this.dna = MUTANT_DNA;
    }

    public Dna build() {
        return new Dna(this.dna);
    }

    public DnaCommand buildCommand() {
        return new DnaCommand(this.dna);
    }
}
