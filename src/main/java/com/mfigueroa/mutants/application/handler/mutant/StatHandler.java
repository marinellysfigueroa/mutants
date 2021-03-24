package com.mfigueroa.mutants.application.handler.mutant;

import com.mfigueroa.mutants.application.command.StatCommand;
import com.mfigueroa.mutants.application.factory.StatFactory;
import com.mfigueroa.mutants.domain.Stat;
import com.mfigueroa.mutants.domain.service.StatService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StatHandler {

    private final StatService statService;
    private final StatFactory statFactory;

    public StatHandler(StatService statService, StatFactory statFactory) {
        this.statService = statService;
        this.statFactory = statFactory;
    }


    @Transactional
    public StatCommand run() {
        Stat stat = this.statService.run();
        StatCommand statCommand =new StatCommand(stat.getCountHumanDna(),stat.getCountMutantDna(),stat.getRatio());
        return statCommand;
    }
}
