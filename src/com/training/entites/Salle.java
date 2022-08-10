package com.training.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salle {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSalle;
	
	private String codeSalle;
	private String adresseCentre;
	private String emailCentre;
	private Boolean telepresenceStagiairePossible;
	private Boolean telepresenceFormateurPossible;
	
	public Salle() {
		
	}
	public Salle(long idSalle, String codeSalle, String adresseCentre, String emailCentre,
			Boolean telepresenceStagiairePossible, Boolean telepresenceFormateurPossible) {
		super();
		this.idSalle = idSalle;
		this.codeSalle = codeSalle;
		this.adresseCentre = adresseCentre;
		this.emailCentre = emailCentre;
		this.telepresenceStagiairePossible = telepresenceStagiairePossible;
		this.telepresenceFormateurPossible = telepresenceFormateurPossible;
	}
	public Salle(String codeSalle, String adresseCentre, String emailCentre,
			Boolean telepresenceStagiairePossible, Boolean telepresenceFormateurPossible) {
		super();
		this.codeSalle = codeSalle;
		this.adresseCentre = adresseCentre;
		this.emailCentre = emailCentre;
		this.telepresenceStagiairePossible = telepresenceStagiairePossible;
		this.telepresenceFormateurPossible = telepresenceFormateurPossible;
	}
	public long getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
	}
	public String getCodeSalle() {
		return codeSalle;
	}
	public void setCodeSalle(String codeSalle) {
		this.codeSalle = codeSalle;
	}
	public String getAdresseCentre() {
		return adresseCentre;
	}
	public void setAdresseCentre(String adresseCentre) {
		this.adresseCentre = adresseCentre;
	}
	public String getEmailCentre() {
		return emailCentre;
	}
	public void setEmailCentre(String emailCentre) {
		this.emailCentre = emailCentre;
	}
	public Boolean getTelepresenceStagiairePossible() {
		return telepresenceStagiairePossible;
	}
	public void setTelepresenceStagiairePossible(Boolean telepresenceStagiairePossible) {
		this.telepresenceStagiairePossible = telepresenceStagiairePossible;
	}
	public Boolean getTelepresenceFormateurPossible() {
		return telepresenceFormateurPossible;
	}
	public void setTelepresenceFormateurPossible(Boolean telepresenceFormateurPossible) {
		this.telepresenceFormateurPossible = telepresenceFormateurPossible;
	}
	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", codeSalle=" + codeSalle + ", adresseCentre=" + adresseCentre
				+ ", emailCentre=" + emailCentre + ", telepresenceStagiairePossible=" + telepresenceStagiairePossible
				+ ", telepresenceFormateurPossible=" + telepresenceFormateurPossible + "]";
	}
	
}
