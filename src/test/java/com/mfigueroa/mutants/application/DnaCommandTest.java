package com.mfigueroa.mutants.application;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.application.factory.DnaFactory;
import com.mfigueroa.mutants.domain.Dna;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DnaCommandTest {

    private static final String[] HUMAN_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGACGC",
            "GCGTCA",
            "TCACTG"
    };

    @Test
    public void AddDnaCommandTest(){
        // Arrange
        DnaCommand dnaCommand = new DnaCommand(HUMAN_DNA);
        dnaCommand.setMutant(true);

        // Act
        DnaFactory dnaFactory = new DnaFactory();
        Dna dna = dnaFactory.addDna(dnaCommand);

        // Assert
        assertEquals(dnaCommand.getDna(), dna.getDna());

    }
}
