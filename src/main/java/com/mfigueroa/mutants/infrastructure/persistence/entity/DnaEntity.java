package com.mfigueroa.mutants.infrastructure.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Dna")
public class DnaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    @Lob
    private String dna;

    @Column()
    private boolean isMutant;

    public void setId(Long id) {
        this.id = id;
    }
    public void setDna(String[] dna) {

        String str = "";
        for (int i = 0; i < dna.length; i++) {
            str += dna[i];
        }
        this.dna =str;
    }
    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
