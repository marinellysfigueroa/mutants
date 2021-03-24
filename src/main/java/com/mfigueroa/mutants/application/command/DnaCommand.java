package com.mfigueroa.mutants.application.command;

public class DnaCommand {

    private Long id;
    private String[] dna;
    private boolean isMutant;

    public DnaCommand(String[] dna) {
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

    public String[] getDna() {
        return dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
