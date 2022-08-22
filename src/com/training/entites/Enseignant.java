package com.training.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity @Table
public class Enseignant {
	
	
	@Id
	@GeneratedValue
	private long idEnseignant;
	@Column
	private String nomEnseignant;
	@Column
	private String prenomEnseignant;
	@Column
	private String emailEnseignant;
	@Column
	private String telEnseignant;
	@Column
	private String adresseEnseignant;
	@Column
	private String skill;
	
	
	@OneToMany (targetEntity = Session.class ,cascade= CascadeType.ALL)
	@JoinColumn(name="es_fk",referencedColumnName = "idEnseignant")
	private Set<Session> sessions ;
	
	public Enseignant() {
		
	}
	public Enseignant(long idEnseignant, String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String telEnseignant, String adresseEnseignant,String skill) {
		super();
		this.idEnseignant = idEnseignant;
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.emailEnseignant = emailEnseignant;
		this.telEnseignant = telEnseignant;
		this.adresseEnseignant = adresseEnseignant;
		this.skill=skill;
	}
	
	public Enseignant(String nomEnseignant, String prenomEnseignant, String emailEnseignant, String telEnseignant, String adresseEnseignant,String skill) {
		super();
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.emailEnseignant = emailEnseignant;
		this.telEnseignant = telEnseignant;
		this.adresseEnseignant = adresseEnseignant;
		this.skill=skill;
		
	}
	
	
	
	
	public Enseignant(Set<Session> sessions) {
		super();
		this.sessions = sessions;
	}
	public long getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(long string) {
		this.idEnseignant = string;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant + ", prenomEnseignant="
				+ prenomEnseignant + ", emailEnseignant=" + emailEnseignant + ", telEnseignant=" + telEnseignant
				+ ", adresseEnseignant=" + adresseEnseignant + ", skill=" + skill + ", sessions=" + sessions + "]";
	}
	
	
}
