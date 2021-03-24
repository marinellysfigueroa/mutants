package com.mfigueroa.mutants.infrastructure.controller;

import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.application.handler.mutant.AddDnaHandler;
import com.mfigueroa.mutants.infrastructure.validators.DnaValidator;
import com.mfigueroa.mutants.infrastructure.validators.dto.Dna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class DnaController {

    private final AddDnaHandler addDnaHandler;

    public DnaController(AddDnaHandler addDnaHandler) {
        this.addDnaHandler = addDnaHandler;
    }

    @Autowired
    private DnaValidator dnaValidator;

    @InitBinder(value = "dna")
    void initDnaValidator(WebDataBinder binder) {
        binder.setValidator(dnaValidator);
    }

    @PostMapping("/mutant")
    public ResponseEntity<String> AddDna(@RequestBody @Valid Dna dna, Errors errors) {

        if (null != errors && errors.getErrorCount() > 0) {
            return new ResponseEntity<String>(errors.getAllErrors().get(0).getCode(),HttpStatus.BAD_REQUEST);

        }else{
            DnaCommand dnaCommand = new DnaCommand(dna.getDna());
            if(this.addDnaHandler.run(dnaCommand).isMutant()){
                return new ResponseEntity<String>(HttpStatus.OK);
            }else
            {
                return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
            }
        }
    }
}
