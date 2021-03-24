package com.mfigueroa.mutants.domain.service;

import com.mfigueroa.mutants.domain.Stat;
import com.mfigueroa.mutants.domain.repository.StatRepository;
import org.springframework.stereotype.Component;

@Component
public class StatService {
    private StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public Stat run() {
        return this.statRepository.getStat();
    }
}
