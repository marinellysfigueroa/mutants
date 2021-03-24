package com.mfigueroa.mutants.application;

import com.mfigueroa.mutants.application.command.StatCommand;
import com.mfigueroa.mutants.application.factory.StatFactory;
import com.mfigueroa.mutants.domain.Stat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatCommandTest {

    private static final Long DEFAULT_COUNT_MUTANT_DNA= Long.valueOf(0);
    private static final Long DEFAULT_COUNT_HUMAN_DNA= Long.valueOf(0);
    private static final double DEFAULT_RATIO=0.0;

    @Test
    public void getDefaultStat(){
        // Arrange
        Stat stat = new Stat(DEFAULT_COUNT_MUTANT_DNA,DEFAULT_COUNT_HUMAN_DNA,DEFAULT_RATIO);

        // Act
        StatFactory statFactory = new StatFactory();

        StatCommand statCommand  = statFactory.setStatCommand(stat);

        // Assert
        assertEquals(statCommand.getCountHumanDna(), stat.getCountHumanDna());
        assertEquals(statCommand.getCountMutantDna(), stat.getCountMutantDna());

    }
}
