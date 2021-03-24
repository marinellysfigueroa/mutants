package com.mfigueroa.mutants.domain;

import com.mfigueroa.mutants.domain.service.ValidateMutantService;
import com.mfigueroa.mutants.testdatabuilder.HumanDnaTestDataBuilder;
import com.mfigueroa.mutants.testdatabuilder.MutantDnaTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateMutantServiceTest {

    @Test
    public void validateIsMuntant() {

        // Arrange
        MutantDnaTestDataBuilder mutantDnaTestDataBuilder = new MutantDnaTestDataBuilder();
        Dna dna = mutantDnaTestDataBuilder.build();

        //Act
        ValidateMutantService validateMutantService = new ValidateMutantService();
        boolean validate =validateMutantService.isMutant(dna.getDna());

        //Assert
        assertTrue(validate);

    }
    @Test
    public void validateIsHuman() {

        // Arrange
        HumanDnaTestDataBuilder humanDnaTestDataBuilder = new HumanDnaTestDataBuilder();
        Dna dna = humanDnaTestDataBuilder.build();

        //Act
        ValidateMutantService validateMutantService = new ValidateMutantService();
        boolean validate =validateMutantService.isMutant(dna.getDna());

        //Assert
        assertFalse(validate);

    }
}
