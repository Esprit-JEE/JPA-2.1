package com.esprit.jpa.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProduitAlimentaire extends Marchandise{

	private static final long serialVersionUID = 1L;
	
	private boolean bio;
	
	@ManyToOne
	private ConditionDeConservation conditionDeConservation;

	public ConditionDeConservation getConditionDeConservation() {
		return conditionDeConservation;
	}

	public void setConditionDeConservation(ConditionDeConservation conditionDeConservation) {
		this.conditionDeConservation = conditionDeConservation;
	}

	public boolean isBio() {
		return bio;
	}

	public void setBio(boolean bio) {
		this.bio = bio;
	}
	
	
}
