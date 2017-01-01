package com.esprit.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Periode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date datedebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	
	@Id
	@ManyToOne
	private Promotion promotion;
	
	@Id
	@ManyToOne
	private Marchandise marchandise;

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Marchandise getMarchandise() {
		return marchandise;
	}

	public void setMarchandise(Marchandise marchandise) {
		this.marchandise = marchandise;
	}
	
	
	
}
