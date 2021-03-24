package com.mfigueroa.mutants.application.command;

public class StatCommand {

    private Long countMutantDna;
    private Long countHumanDna;
    private double ratio;

    public StatCommand(Long countMutantDna, Long countHumanDna, double ratio) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = ratio;
    }

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
