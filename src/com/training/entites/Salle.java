package com.training.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salle {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSalle;
	
	private String nomSalle;

	public Salle() {
		
	}
	public Salle(long idSalle, String nomSalle) {
		super();
		this.idSalle = idSalle;
		this.nomSalle = nomSalle;
	}
	public Salle(String nomSalle) {
		super();
		this.nomSalle=nomSalle;
	}
	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", nomSalle=" + nomSalle + "]";
	}
	
}
