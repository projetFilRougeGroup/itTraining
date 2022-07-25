package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Prerequis {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPrerequis;
	
	private String descriptionPrerequis;
	
	private String quizz;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Set<Formation> formation = new HashSet<Formation>();
	
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
	public Set<Formation> getFormation() {
		return formation;
	}
	public void setFormation(Set<Formation> formation) {
		this.formation = formation;
	}
	@Override
	public String toString() {
		return "Prerequis [idPrerequis=" + idPrerequis + ", descriptionPrerequis=" + descriptionPrerequis + ", quizz="
				+ quizz + ", formations=" + formation + "]";
	}
		
}
