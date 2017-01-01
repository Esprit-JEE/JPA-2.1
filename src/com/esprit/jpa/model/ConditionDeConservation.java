package com.esprit.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ConditionDeConservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private int temperature;
	
	private float humidite;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<ProduitAlimentaire> produitAlimentaires;


	public List<ProduitAlimentaire> getProduitAlimentaires() {
		return produitAlimentaires;
	}

	public void setProduitAlimentaires(List<ProduitAlimentaire> produitAlimentaires) {
		this.produitAlimentaires = produitAlimentaires;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public float getHumidite() {
		return humidite;
	}

	public void setHumidite(float humidite) {
		this.humidite = humidite;
	}

	@Override
	public String toString() {
		return "ConditionDeConservation [id=" + id + ", temperature=" + temperature + ", humidite=" + humidite
				+ ", produitAlimentaires=" + produitAlimentaires + "]";
	}
	
	


	
	

}
