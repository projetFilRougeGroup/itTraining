package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cette classe représente la Formation. C'est une entité persistance vu qu'on l'a annotée avec l'annotation Entity.
 * @author <a href="https://github.com/projetFilRougeGroup/itTraining">it-training</a>
 *
 */

@Entity
public class Formation {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormation;
	
	private String nomFormation;
	private String referenceFormation;
	
	private String publicFormation;
	private String objectifsFormation;
	private String detailsFormation;
	
	private String chaptersFormation;
	
	private float priceFormation;
	
	private int dureeFormation;
	
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_Formation_Prerequis", joinColumns=@JoinColumn(name="Formation_id"), inverseJoinColumns=@JoinColumn(name="Prereq_id"))
	private Set<Prerequis> formationPrerequis = new HashSet<>();
	
	@ManyToMany (cascade=CascadeType.PERSIST, mappedBy="formation")
	private Set<Theme> theme = new HashSet<>();
	
	@OneToMany (cascade=CascadeType.PERSIST, mappedBy="formation")
	private Set<Session> sessions = new HashSet<>();
	
	public Formation() {
		
	}
	public Formation(long idFormation, String nomFormation, String referenceFormation,
			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation,
			int dureeFormation) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormation;
		this.referenceFormation = referenceFormation;
		
		this.publicFormation = publicFormation;
		this.objectifsFormation = objectifsFormation;
		this.detailsFormation = detailsFormation;
		this.chaptersFormation = chaptersFormation;
		this.priceFormation=priceFormation;
		this.dureeFormation = dureeFormation;
	
	}
	public Formation(String nomFormation, String referenceFormation,
			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation,
			int dureeFormation) {
		super();
		this.nomFormation = nomFormation;
		this.referenceFormation = referenceFormation;
		
		this.publicFormation = publicFormation;
		this.objectifsFormation = objectifsFormation;
		this.detailsFormation = detailsFormation;
		this.chaptersFormation = chaptersFormation;
		this.priceFormation=priceFormation;
		this.dureeFormation = dureeFormation;
	
	}
	public long getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(long idFormation) {
		this.idFormation = idFormation;
	}
	public String getNomFormation() {
		return nomFormation;
	}
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	public String getReferenceFormation() {
		return referenceFormation;
	}
	public void setReferenceFormation(String referenceFormation) {
		this.referenceFormation = referenceFormation;
	}
	
	public String getPublicFormation() {
		return publicFormation;
	}
	public void setPublicFormation(String publicFormation) {
		this.publicFormation = publicFormation;
	}
	public String getObjectifsFormation() {
		return objectifsFormation;
	}
	public void setObjectifsFormation(String objectifsFormation) {
		this.objectifsFormation = objectifsFormation;
	}
	public String getDetailsFormation() {
		return detailsFormation;
	}
	public void setDetailsFormation(String detailsFormation) {
		this.detailsFormation = detailsFormation;
	}
	public String getChaptersFormation() {
		return chaptersFormation;
	}
	public void setChaptersFormation(String chaptersFormation) {
		this.chaptersFormation = chaptersFormation;
	}

	
	public float getPriceFormation() {
		return priceFormation;
	}
	public void setPriceFormation(float priceFormation) {
		this.priceFormation = priceFormation;
	}
	public int getDureeFormation() {
		return dureeFormation;
	}
	public void setDureeFormation(int dureeFormation) {
		this.dureeFormation = dureeFormation;
	}
	
	public Set<Theme> getTheme() {
		return theme;
	}
	public void setTheme(Set<Theme> theme) {
		this.theme = theme;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	public Set<Prerequis> getFormationPrerequis() {
		return formationPrerequis;
	}
	public void setFormationPrerequis(Set<Prerequis> formationPrerequis) {
		this.formationPrerequis = formationPrerequis;
	}
	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", referenceFormation="
				+ referenceFormation + ", publicFormation=" + publicFormation + ", objectifsFormation="
				+ objectifsFormation + ", detailsFormation=" + detailsFormation + ", chaptersFormation="
				+ chaptersFormation + ", priceFormation=" + priceFormation + ", dureeFormation=" + dureeFormation
				+ ", formationPrerequis=" + formationPrerequis + ", theme=" + theme + ", sessions=" + sessions + "]";
	}		
}
