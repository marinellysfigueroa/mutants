package com.mfigueroa.mutants.infrastructure.controller;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.application.handler.mutant.AddDnaHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DnaController {

    private final AddDnaHandler addDnaHandler;

    public DnaController(AddDnaHandler addDnaHandler) {
        this.addDnaHandler = addDnaHandler;
    }

    @PostMapping("/mutant")
    public ResponseEntity<String> AddDna(@RequestBody DnaCommand dnaCommand) {

        if(this.addDnaHandler.run(dnaCommand).isMutant()){
            return new ResponseEntity<String>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }

    }


}
