package com.esprit.jpa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompositionChimique implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String composant;
	
}
