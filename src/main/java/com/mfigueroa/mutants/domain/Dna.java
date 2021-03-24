package com.mfigueroa.mutants.domain;

public class Dna {
	private Long id;
	private String[] dna;
	private boolean isMutant;

	public Dna(Long id, String[] dna, boolean isMutant) {
		this.id = id;
		this.dna = dna;
		this.isMutant = isMutant;
	}

	public Dna(String[] dna) {
		this.dna = dna;
	}

	public Long getId() {
		return id;
	}

	public String[] getDna() {
		return dna;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean mutant) {
		isMutant = mutant;
	}
}
