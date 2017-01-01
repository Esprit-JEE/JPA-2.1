package com.esprit.jpa.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProduitAlimentaire extends Marchandise{

	private static final long serialVersionUID = 1L;
	
	private boolean bio;
	
	@ManyToOne
	private ConditionDeConservation conditionDeConservations;
	

	public ConditionDeConservation getConditionDeConservations() {
		return conditionDeConservations;
	}

	public void setConditionDeConservations(ConditionDeConservation conditionDeConservations) {
		this.conditionDeConservations = conditionDeConservations;
	}

	public boolean isBio() {
		return bio;
	}

	public void setBio(boolean bio) {
		this.bio = bio;
	}
	
	
}
