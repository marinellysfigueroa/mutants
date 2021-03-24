package com.mfigueroa.mutants.infrastructure.validators;

import com.mfigueroa.mutants.infrastructure.validators.dto.Dna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Locale;

@Component
public class DnaValidator implements Validator {

    public static final String DNA_REGEX = "[ACGT]+";
    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return Dna.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Dna dna = (Dna) target;

        // Validate null chain
        if (dna.getDna() == null) {
            errors.rejectValue("dna", messageSource.getMessage("dna.nullval.error", null, Locale.getDefault()));
        } else {
            // Validate empty
            if (dna.getDna().length == 0) {
                errors.rejectValue("dna", messageSource.getMessage("dna.emptyval.error", null, Locale.getDefault()));
            } else {
                for (int i = 0; i < dna.getDna().length; i++) {

                    // Validate NxN
                    if (dna.getDna()[i].length() != dna.getDna().length) {
                        errors.rejectValue("dna", messageSource.getMessage("dna.notnxn.error", null, Locale.getDefault()));
                    }
                    // Validate each character
                    if (!dna.getDna()[i].matches(DNA_REGEX)) {
                        errors.rejectValue("dna", messageSource.getMessage("dna.notallowed.error", null, Locale.getDefault()));
                    }

                }
            }

        }

    }
}
