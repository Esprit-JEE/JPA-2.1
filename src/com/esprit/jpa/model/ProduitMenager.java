package com.esprit.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class ProduitMenager extends Marchandise{

	private static final long serialVersionUID = 1L;
	
	private boolean toxique;
	
	@ManyToMany
	private List<CompositionChimique> compositionChimiques;
	

	public List<CompositionChimique> getCompositionChimiques() {
		return compositionChimiques;
	}

	public void setCompositionChimiques(List<CompositionChimique> compositionChimiques) {
		this.compositionChimiques = compositionChimiques;
	}

	public boolean isToxique() {
		return toxique;
	}

	public void setToxique(boolean toxique) {
		this.toxique = toxique;
	}
	
}
