package com.mfigueroa.mutants.domain;

import java.util.Objects;

public class Stat {

    private Long countMutantDna;
    private Long countHumanDna;
    private double ratio;

    public Stat(Long countMutantDna, Long countHumanDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
    }

    public Stat() {

    }

    public Long getCountMutantDna() {
        return countMutantDna;
    }

    public Long getCountHumanDna() {
        return countHumanDna;
    }

    public double getRatio() {
        ratio = 0;
        if (this.countHumanDna != 0) {
            ratio = this.countMutantDna / this.countHumanDna;
        }
        return ratio;
    }

}
