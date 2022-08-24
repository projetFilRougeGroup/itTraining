package com.training.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Prerequis implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3535848206311670941L;

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPrerequis;
	
	private String descriptionPrerequis;
	
	private String quizz;
	
	
	@ManyToMany(mappedBy="formationPrerequis", fetch= FetchType.EAGER)
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
	@Override
	public int hashCode() {
		return Objects.hash(idPrerequis);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prerequis other = (Prerequis) obj;
		return idPrerequis == other.idPrerequis;
	}	
}
