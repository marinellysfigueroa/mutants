package com.mfigueroa.mutants.application.handler.mutant;

import com.mfigueroa.mutants.domain.Stat;
import com.mfigueroa.mutants.domain.service.StatService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StatHandler {

    private final StatService statService;

    public StatHandler(StatService statService) {
        this.statService = statService;
    }


    @Transactional
    public Stat run() {
        return this.statService.run();
    }
}
