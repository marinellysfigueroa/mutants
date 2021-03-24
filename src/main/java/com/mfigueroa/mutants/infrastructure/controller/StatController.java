package com.mfigueroa.mutants.infrastructure.controller;

import com.mfigueroa.mutants.application.command.StatCommand;
import com.mfigueroa.mutants.application.handler.mutant.StatHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class StatController {

    private final StatHandler statHandler;

    public StatController(StatHandler statHandler) {
        this.statHandler = statHandler;
    }

    @GetMapping("/stats")
    public ResponseEntity getStat() {
        StatCommand statCommand = this.statHandler.run();
        return new ResponseEntity(statCommand,HttpStatus.OK);

    }

}
