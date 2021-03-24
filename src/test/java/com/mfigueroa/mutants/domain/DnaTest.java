package com.mfigueroa.mutants.domain;

import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.testdatabuilder.HumanDnaTestDataBuilder;
import com.mfigueroa.mutants.testdatabuilder.MutantDnaTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DnaTest {

    private static final String[] HUMAN_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGACGC",
            "GCGTCA",
            "TCACTG"
    };

    private static final String[] MUTANT_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGC",
            "CCCCTA",
            "TCACTG"
    };

    @Test
    public void AddMutantTest(){
        // Arrange
        MutantDnaTestDataBuilder mutantDnaTestDataBuilder= new MutantDnaTestDataBuilder();

        // Act
        Dna dna = mutantDnaTestDataBuilder.build();

        // Assert
        assertEquals(MUTANT_DNA, dna.getDna());

    }

    @Test
    public  void AddHumanTest(){

        // Arrange
        HumanDnaTestDataBuilder humanDnaTestDataBuilder= new HumanDnaTestDataBuilder();

        // Act
        Dna dna = humanDnaTestDataBuilder.build();

        // Assert
        assertEquals(HUMAN_DNA, dna.getDna());

    }


}
