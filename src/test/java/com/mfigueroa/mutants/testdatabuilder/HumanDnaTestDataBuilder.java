package com.mfigueroa.mutants.testdatabuilder;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.domain.Dna;

public class HumanDnaTestDataBuilder {
    private static final String[] HUMAN_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGACGC",
            "GCGTCA",
            "TCACTG"
    };
    private String dna[];

    public HumanDnaTestDataBuilder() {
        this.dna = HUMAN_DNA;
    }

    public Dna build() {
        return new Dna(this.dna);
    }

    public DnaCommand buildCommand() {
        return new DnaCommand(this.dna);
    }
}
