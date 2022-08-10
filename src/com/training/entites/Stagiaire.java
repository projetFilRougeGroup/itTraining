package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Stagiaire {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idStagiaire;
	private String nomStagiaire;
	private String prenomStagiaire;
	private String emailStagiaire;
	private String telStagiaire;
	private String adresseStagiaire;
	
	@ManyToMany (cascade=CascadeType.PERSIST,mappedBy="stagiaires")
	private Set<Session> sessions = new HashSet<Session>();
	
	public Stagiaire() {
		
	}
	public Stagiaire(long idStagiaire, String nomStagiaire, String prenomStagiaire, String emailStagiaire,
			String telStagiaire, String adresseStagiaire) {
		super();
		this.idStagiaire = idStagiaire;
		this.nomStagiaire = nomStagiaire;
		this.prenomStagiaire = prenomStagiaire;
		this.emailStagiaire = emailStagiaire;
		this.telStagiaire = telStagiaire;
		this.adresseStagiaire = adresseStagiaire;
	}
	public Stagiaire(String nomStagiaire, String prenomStagiaire, String emailStagiaire,
			String telStagiaire, String adresseStagiaire) {
		super();
		this.nomStagiaire = nomStagiaire;
		this.prenomStagiaire = prenomStagiaire;
		this.emailStagiaire = emailStagiaire;
		this.telStagiaire = telStagiaire;
		this.adresseStagiaire = adresseStagiaire;		
	}
	public long getIdStagiaire() {
		return idStagiaire;
	}
	public void setIdStagiaire(long idStagiaire) {
		this.idStagiaire = idStagiaire;
	}
	public String getNomStagiaire() {
		return nomStagiaire;
	}
	public void setNomStagiaire(String nomStagiaire) {
		this.nomStagiaire = nomStagiaire;
	}
	public String getPrenomStagiaire() {
		return prenomStagiaire;
	}
	public void setPrenomStagiaire(String prenomStagiaire) {
		this.prenomStagiaire = prenomStagiaire;
	}
	public String getEmailStagiaire() {
		return emailStagiaire;
	}
	public void setEmailStagiaire(String emailStagiaire) {
		this.emailStagiaire = emailStagiaire;
	}
	
	public String getTelStagiaire() {
		return telStagiaire;
	}
	public void setTelStagiaire(String telStagiaire) {
		this.telStagiaire = telStagiaire;
	}
	public String getAdresseStagiaire() {
		return adresseStagiaire;
	}
	public void setAdresseStagiaire(String adresseStagiaire) {
		this.adresseStagiaire = adresseStagiaire;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + idStagiaire + ", nomStagiaire=" + nomStagiaire + ", prenomStagiaire="
				+ prenomStagiaire + ", emailStagiaire=" + emailStagiaire + ", telStagiaire=" + telStagiaire
				+ ", adresseStagiaire=" + adresseStagiaire + ", sessions=" + sessions + "]";
	}
	
}
