package com.mfigueroa.mutants.application.command;

public class DnaCommand {

    private Long id;
    private String[] dna;
    private boolean isMutant;

    public DnaCommand(String[] dna) {
        this.dna = dna;
    }

    public DnaCommand(Long id, String[] dna, boolean isMutant) {
        this.id = id;
        this.dna = dna;
        this.isMutant = isMutant;
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
