package com.mfigueroa.mutants.domain.service;

import org.springframework.stereotype.Component;

@Component
public class ValidateMutantService {

    // Constants according to the statement
    private static final int MIN_OCURRENCE = 2;
    private static final int NUM_EQUAL_LETTERS = 3;
    private static final String[] ALLOWED_LETTERS = {"A", "T", "C", "G"};

    public boolean isMutant(String dna[]) {

        // Get DNA Nitrogenous Bases
        String[] nitrogenousBasesDna = this.getNitrogenousBasesDna();
        // Initialize the number of occurrences
        int numberOcurrences = 0;

        // Validate occurrences for each element of the DNA Nitrogenous Bases allowed
        for (int i = 0; i < nitrogenousBasesDna.length; i++) {
            numberOcurrences += this.countNumberOccurrences(dna, nitrogenousBasesDna[i]);

        }
        // Validate if number of occurrences is mayor of min number of occurrences required
        boolean isMutant = numberOcurrences >= MIN_OCURRENCE;

        return isMutant;
    }

    private int countNumberOccurrences(String dna[], String s) {

        // Initialize number of occurrences
        int occurrences = 0;

        // Get Horizontal and Vertical Occurrences
        occurrences = getHorizontalVerticalOccurrences(dna, s, occurrences);

        // Calculate difference between the dimension of the matrix and the length of the sequence
        int lengthDifference = dna.length - s.length();

        // Obtain the occurrences in the lower diagonal and central diagonal, from top to bottom
        occurrences = getTopDownCentralBottomDiagonalOccurrences(dna, s, occurrences, lengthDifference);

        // Get the occurrences in the upper diagonal, from top to bottom
        occurrences = getGetTopBottomTopDiagonalOccurrences(dna, s, occurrences, lengthDifference);


        // Get occurrences on the bottom diagonal and center diagonal, from bottom to top
        occurrences = getGetBottomUpBottomCenterDiagonalOccurrences(dna, s, occurrences, lengthDifference);

        // Get occurrences on the top diagonal, bottom up
        occurrences = getBottomTopTopDiagonalOccurrences(dna, s, occurrences, lengthDifference);
        return occurrences;
    }

    private int getBottomTopTopDiagonalOccurrences(String[] dna, String s, int occurrences, int lengthDifference) {
        for (int i = 0; i < lengthDifference; i++) {
            String chain = "";

            for (int j = i + 1; j < dna.length; j++) {
                chain += dna[dna.length - j + i].charAt(j);
            }

            if (chain.contains(s)) {
                occurrences++;
            }

        }
        return occurrences;
    }

    private int getGetBottomUpBottomCenterDiagonalOccurrences(String[] dna, String s, int occurrences, int lengthDifference) {
        for (int i = lengthDifference + 1; i < dna.length; i++) {
            String chain = "";
            for (int j = 0; j <= i; j++) {
                chain += dna[i - j].charAt(j);
            }

            if (chain.contains(s)) {
                occurrences++;
            }

        }
        return occurrences;
    }

    private int getGetTopBottomTopDiagonalOccurrences(String[] dna, String s, int occurrences, int lengthDifference) {
        for (int i = 1; i <= lengthDifference; i++) {
            String chain = "";
            for (int j = 0; j < dna.length - i; j++) {
                chain += dna[j].charAt(i + j);
            }
            if (chain.contains(s)) {
                occurrences++;
            }

        }
        return occurrences;
    }

    private int getTopDownCentralBottomDiagonalOccurrences(String[] dna, String s, int occurrences, int lengthDifference) {
        for (int i = lengthDifference; i >= 0; i--) {
            String chain = "";
            for (int j = 0; j < dna.length - i; j++) {
                chain += dna[i + j].charAt(j);
            }
            if (chain.contains(s)) {
                occurrences++;
            }

        }
        return occurrences;
    }

    private int getHorizontalVerticalOccurrences(String[] dna, String s, int occurrences) {
        for (int i = 0; i < dna.length; i++) {
            // Search for horizontal occurrences
            if (dna[i].contains(s)) {
                occurrences++;
            }

            // Create the vertical diagonal
            String chain = "";
            for (int j = 0; j < dna.length; j++) {
                chain += dna[j].charAt(i);
            }

            // Search for vertical occurrences
            if (chain.contains(s)) {
                occurrences++;
            }

        }
        return occurrences;
    }

    private String[] getNitrogenousBasesDna() {

        String[] nitrogenousBasesDna = new String[this.NUM_EQUAL_LETTERS];

        for (int i = 0; i < this.NUM_EQUAL_LETTERS; i++) {
            String chain = "";

            for (int j = 0; j < this.ALLOWED_LETTERS.length; j++) {
                chain += this.ALLOWED_LETTERS[i];
            }
            nitrogenousBasesDna[i] = chain;
        }
        return nitrogenousBasesDna;
    }

}
