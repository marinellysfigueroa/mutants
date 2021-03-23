package com.mfigueroa.mutants.domain.service;

import com.mfigueroa.mutants.domain.Dna;
import com.mfigueroa.mutants.domain.repository.DnaRepository;
import org.springframework.stereotype.Component;

@Component
public class AddDnaService {
    private DnaRepository dnaRepository;
    private final ValidateMutantService validateMutantService;

    public AddDnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
        validateMutantService = new ValidateMutantService();
    }

    public Dna run(Dna dna) {
        //En este servicio se incluye la lógica de negicio
        dna.setMutant(validateMutantService.isMutant(dna.getDna()));
        this.dnaRepository.addDna(dna);
        return dna;
    }
}
