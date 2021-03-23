package com.mfigueroa.mutants.infrastructure.controller;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.application.handler.mutant.StatHandler;
import com.mfigueroa.mutants.domain.Stat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {

    private final StatHandler statHandler;

    public StatController(StatHandler statHandler) {
        this.statHandler = statHandler;
    }


    @GetMapping("/stats")
    public Stat getStat() {
        System.out.print("Entra a stat");
        return this.statHandler.run();

    }


}
