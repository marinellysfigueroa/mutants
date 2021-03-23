package com.mfigueroa.mutants.infrastructure.configuration;

import com.mfigueroa.mutants.domain.repository.DnaRepository;
import com.mfigueroa.mutants.domain.service.AddDnaService;
import com.mfigueroa.mutants.domain.service.ValidateMutantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {
    @Bean
    public AddDnaService addDnaService(DnaRepository dnaRepository) {
        return new AddDnaService(dnaRepository);
    }
}
