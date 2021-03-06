package com.training.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private int dureeFormation;
	private String domaineFormation;
	
	public Formation() {
		
	}
//idFormation; ID is generated in the db, see @Id@GeneratedValue
//	public Formation(long idFormation, String nomFormation, String referenceFormation, String prerequisFormation,
//			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,
//			int dureeFormation, String domaineFormation) {
//		super();
//		this.idFormation = 
//		this.nomFormation = nomFormation;
//		this.referenceFormation = referenceFormation;
//		this.prerequisFormation = prerequisFormation;
//		this.publicFormation = publicFormation;
//		this.objectifsFormation = objectifsFormation;
//		this.detailsFormation = detailsFormation;
//		this.chaptersFormation = chaptersFormation;
//		this.dureeFormation = dureeFormation;
//		this.domaineFormation = domaineFormation;
//	}
	public Formation(String nomFormation, String referenceFormation, String prerequisFormation,
			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,
			int dureeFormation, String domaineFormation) {
		super();
		this.nomFormation = nomFormation;
		this.referenceFormation = referenceFormation;
		this.prerequisFormation = prerequisFormation;
		this.publicFormation = publicFormation;
		this.objectifsFormation = objectifsFormation;
		this.detailsFormation = detailsFormation;
		this.chaptersFormation = chaptersFormation;
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
	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", referenceFormation="
				+ referenceFormation + ", prerequisFormation=" + prerequisFormation + ", publicFormation="
				+ publicFormation + ", objectifsFormation=" + objectifsFormation + ", detailsFormation="
				+ detailsFormation + ", chaptersFormation=" + chaptersFormation + ", dureeFormation=" + dureeFormation
				+ ", domaineFormation=" + domaineFormation + "]";
	}

	
	
	
	
	

}
