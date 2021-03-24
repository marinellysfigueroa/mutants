package com.mfigueroa.mutants.application.factory;

import com.mfigueroa.mutants.application.command.StatCommand;
import com.mfigueroa.mutants.domain.Stat;
import org.springframework.stereotype.Component;

@Component
public class StatFactory {
    public StatCommand setStatCommand(Stat stat){
        return new StatCommand(stat.getCountMutantDna(),stat.getCountMutantDna(),stat.getRatio());

    }
}
