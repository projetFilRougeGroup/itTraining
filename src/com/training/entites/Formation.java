package com.training.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private String prerequisFormation;
	private String publicFormation;
	private String objectifsFormation;
	private String detailsFormation;
	
	private String chaptersFormation;
	private int priceFormation;
	private int dureeFormation;
	private String domaineFormation;
	
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Set<Prerequis> prerequis = new HashSet<>();
	
	@ManyToMany (cascade=CascadeType.PERSIST, mappedBy="formation")
	private Set<Theme> theme = new HashSet<>();
	
	@OneToMany (cascade=CascadeType.PERSIST, mappedBy="formation")
	private Set<Session> sessions = new HashSet<>();
	
	public Formation() {
		
	}
	public Formation(long idFormation, String nomFormation, String referenceFormation, String prerequisFormation,
			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation,
			int dureeFormation, String domaineFormation) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormation;
		this.referenceFormation = referenceFormation;
		this.prerequisFormation = prerequisFormation;
		this.publicFormation = publicFormation;
		this.objectifsFormation = objectifsFormation;
		this.detailsFormation = detailsFormation;
		this.chaptersFormation = chaptersFormation;
		this.priceFormation=priceFormation;
		this.dureeFormation = dureeFormation;
		this.domaineFormation = domaineFormation;
	}
	public Formation(String nomFormation, String referenceFormation, String prerequisFormation,
			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation,
			int dureeFormation, String domaineFormation) {
		super();
		this.nomFormation = nomFormation;
		this.referenceFormation = referenceFormation;
		this.prerequisFormation = prerequisFormation;
		this.publicFormation = publicFormation;
		this.objectifsFormation = objectifsFormation;
		this.detailsFormation = detailsFormation;
		this.chaptersFormation = chaptersFormation;
		this.priceFormation=priceFormation;
		this.dureeFormation = dureeFormation;
		this.domaineFormation = domaineFormation;
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
	public String getPrerequisFormation() {
		return prerequisFormation;
	}
	public void setPrerequisFormation(String prerequisFormation) {
		this.prerequisFormation = prerequisFormation;
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

	public int getPriceFormation() {
		return priceFormation;
	}
	public void setPriceFormation(int priceFormation) {
		this.priceFormation = priceFormation;
	}
	public int getDureeFormation() {
		return dureeFormation;
	}
	public void setDureeFormation(int dureeFormation) {
		this.dureeFormation = dureeFormation;
	}
	public String getDomaineFormation() {
		return domaineFormation;
	}
	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}
		
	public Set<Prerequis> getPrerequis() {
		return prerequis;
	}
	public void setPrerequis(Set<Prerequis> prerequis) {
		this.prerequis = prerequis;
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
	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", referenceFormation="
				+ referenceFormation + ", prerequisFormation=" + prerequisFormation + ", publicFormation="
				+ publicFormation + ", objectifsFormation=" + objectifsFormation + ", detailsFormation="
				+ detailsFormation + ", chaptersFormation=" + chaptersFormation + ", priceFormation=" + priceFormation
				+ ", dureeFormation=" + dureeFormation + ", domaineFormation=" + domaineFormation + ", prerequis="
				+ prerequis + ", theme=" + theme + ", sessions=" + sessions + "]";
	}
	
}
