package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enseignant {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEnseignant;
	
	private String nomEnseignant;
	private String prenomEnseignant;
	private String emailEnseignant;
	private String telEnseignant;
	private String adresseEnseignant;
	
	@OneToMany (cascade=CascadeType.PERSIST,mappedBy="enseignant")
	private Set<Session> sessions = new HashSet<Session>();
	
	public Enseignant() {
		
	}
	public Enseignant(long idEnseignant, String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String telEnseignant, String adresseEnseignant) {
		super();
		this.idEnseignant = idEnseignant;
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.emailEnseignant = emailEnseignant;
		this.telEnseignant = telEnseignant;
		this.adresseEnseignant = adresseEnseignant;
	}
	
	public Enseignant(String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String telEnseignant, String adresseEnseignant) {
		super();
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.emailEnseignant = emailEnseignant;
		this.telEnseignant = telEnseignant;
		this.adresseEnseignant = adresseEnseignant;
	}
	public long getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public String getNomEnseignant() {
		return nomEnseignant;
	}
	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}
	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}
	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}
	public String getEmailEnseignant() {
		return emailEnseignant;
	}
	public void setEmailEnseignant(String emailEnseignant) {
		this.emailEnseignant = emailEnseignant;
	}
	
	
	public String getTelEnseignant() {
		return telEnseignant;
	}
	public void setTelEnseignant(String telEnseignant) {
		this.telEnseignant = telEnseignant;
	}
	public String getAdresseEnseignant() {
		return adresseEnseignant;
	}
	public void setAdresseEnseignant(String adresseEnseignant) {
		this.adresseEnseignant = adresseEnseignant;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant + ", prenomEnseignant="
				+ prenomEnseignant + ", emailEnseignant=" + emailEnseignant + ", telEnseignant=" + telEnseignant
				+ ", adresseEnseignant=" + adresseEnseignant + ", sessions=" + sessions + "]";
	}
	
}
