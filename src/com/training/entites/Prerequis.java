package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Prerequis {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPrerequis;
	
	private String descriptionPrerequis;
	
	private String quizz;
	
	
	@ManyToMany(mappedBy="formationPrerequis")
	private Set<Formation> preqs = new HashSet<Formation>();
	
	
	
	public Prerequis() {
		
	}
	public Prerequis(long idPrerequis, String descriptionPrerequis, String quizz) {
		super();
		this.idPrerequis = idPrerequis;
		this.descriptionPrerequis = descriptionPrerequis;
		this.quizz = quizz;
	}
	public Prerequis(String descriptionPrerequis, String quizz) {
		super();
		this.descriptionPrerequis=descriptionPrerequis;
		this.quizz=quizz;
	}
	public long getIdPrerequis() {
		return idPrerequis;
	}
	public void setIdPrerequis(long idPrerequis) {
		this.idPrerequis = idPrerequis;
	}
	public String getDescriptionPrerequis() {
		return descriptionPrerequis;
	}
	public void setDescriptionPrerequis(String descriptionPrerequis) {
		this.descriptionPrerequis = descriptionPrerequis;
	}
	public String getQuizz() {
		return quizz;
	}
	public void setQuizz(String quizz) {
		this.quizz = quizz;
	}
	public Set<Formation> getPreqs() {
		return preqs;
	}
	public void setPreqs(Set<Formation> preqs) {
		this.preqs = preqs;
	}
	@Override
	public String toString() {
		return "Prerequis [idPrerequis=" + idPrerequis + ", descriptionPrerequis=" + descriptionPrerequis + ", quizz="
				+ quizz + ", preqs=" + preqs + "]";
	}	
}
