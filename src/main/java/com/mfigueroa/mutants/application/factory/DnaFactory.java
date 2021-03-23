package com.mfigueroa.mutants.application.factory;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.domain.Dna;
import org.springframework.stereotype.Component;

@Component
public class DnaFactory {
    public Dna addDna(DnaCommand dnaCommand){
        return new Dna(dnaCommand.getId(),dnaCommand.getDna(),dnaCommand.isMutant());

    }
}
