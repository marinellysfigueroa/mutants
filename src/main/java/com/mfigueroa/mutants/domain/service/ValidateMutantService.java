package com.mfigueroa.mutants.domain.service;

import com.mfigueroa.mutants.domain.Dna;
import org.springframework.stereotype.Component;

@Component
public class ValidateMutantService {
    private static final int MIN_OCURRENCE = 4;
    String[] nitrogenousBasesDna = {"AAAA", "TTTT", "CCCC", "GGGG"};


    public boolean isMutant(String dna[]){
        System.out.println("ADN"+dna);

        // Initialize the number of occurrences
        int numberOcurrences= 0;

        // For each element of the DNA sequence
        for (int i = 0; i < dna.length; i++) {
            System.out.println("ADN del elemento "+i+" "+dna[i]);
            numberOcurrences += this.countNumberOccurrences(dna[i]);
            System.out.println("numberOcurrences "+numberOcurrences);
        }

        boolean isMutant = numberOcurrences >= MIN_OCURRENCE;


        System.out.println("isMutant "+isMutant);

        return isMutant;
    }

    private int countNumberOccurrences(String s) {

        int ocurrences=0;
        //para cada una de las posibles secuencias

        System.out.println("string "+s);
        for (int j=0; j<nitrogenousBasesDna.length; j++)
        {

            //horizontal
            System.out.println("nitrogenousBasesDna "+nitrogenousBasesDna[j]);
            if(s.contains(nitrogenousBasesDna[j])){
                ocurrences++;
            }

            //Compongo la diagonal vertical
            String sequenceToAnalyze = "";
            for (int k = 0; k < nitrogenousBasesDna.length - 1; k++) {
                sequenceToAnalyze += nitrogenousBasesDna[k].charAt(j);
            }
            System.out.println("sequenceToAnalyze "+sequenceToAnalyze);

            // verticales
            if (sequenceToAnalyze.contains(s))
                ocurrences++;
        }

        System.out.println("ocurrences "+ocurrences);
        return ocurrences;
    }

}
