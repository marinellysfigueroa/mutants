package com.mfigueroa.mutants.domain;

import com.mfigueroa.mutants.testdatabuilder.StatTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatTest {

    private static final Long DEFAULT_COUNT_MUTANT_DNA= Long.valueOf(0);
    private static final Long DEFAULT_COUNT_HUMAN_DNA= Long.valueOf(0);
    private static final double DEFAULT_RATIO=0.0;

    @Test
    public void getDefaultStat(){
        // Arrange
        StatTestDataBuilder statTestDataBuilder = new StatTestDataBuilder();

        // Act
        Stat stat = statTestDataBuilder.build();

        // Assert
        assertEquals(DEFAULT_COUNT_MUTANT_DNA, stat.getCountMutantDna());
        assertEquals(DEFAULT_COUNT_HUMAN_DNA, stat.getCountHumanDna());
    }




}
