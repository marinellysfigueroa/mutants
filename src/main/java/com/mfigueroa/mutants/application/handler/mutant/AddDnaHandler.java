package com.mfigueroa.mutants.application.handler.mutant;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.application.factory.DnaFactory;
import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.domain.service.AddDnaService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddDnaHandler {

    private final AddDnaService addDnaService;
    private  final DnaFactory dnaFactory;

    public AddDnaHandler(AddDnaService addDnaService, DnaFactory dnaFactory) {
        this.addDnaService = addDnaService;
        this.dnaFactory = dnaFactory;
    }

    @Transactional
    public Dna run(DnaCommand dnaCommand) {
        Dna dna = this.dnaFactory.addDna(dnaCommand);
        return  this.addDnaService.run(dna);

    }
}
