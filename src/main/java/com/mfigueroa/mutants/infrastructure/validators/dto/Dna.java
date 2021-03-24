package com.mfigueroa.mutants.infrastructure.validators.dto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Dna implements Serializable {

    private static final long serialVersionUID = 1L;
    private String [] dna;

    public String[] getDna() {
        return dna;
    }
}
