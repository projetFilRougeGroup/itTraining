package com.training.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import com.training.daos.DAOSession;
import com.training.daos.DAOStagiaire;

@Entity
@Table(name = "Stagiaire")
public class Stagiaire {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)@Column(name = "IDSTAGIAIRE")
	private long idStagiaire;
	private String nomStagiaire;
	private String prenomStagiaire;
	
	@NaturalId
	private String emailStagiaire;
	private String telStagiaire;
	private String adresseStagiaire;
	
    @OneToMany(
            mappedBy = "stagiaire",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )	
	private Set<Evaluation> evaluations = new HashSet<Evaluation>();
	
	public Stagiaire() {
		
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
			String telStagiaire, String adresseStagiaire, Evaluation evaluation) {
		super();
		this.nomStagiaire = nomStagiaire;
		this.prenomStagiaire = prenomStagiaire;
		this.emailStagiaire = emailStagiaire;
		this.telStagiaire = telStagiaire;
		this.adresseStagiaire = adresseStagiaire;
		this.evaluations.add(evaluation);
	}
	public Stagiaire(String nomStagiaire, String prenomStagiaire, String emailStagiaire,
			String telStagiaire, String adresseStagiaire, Set<Evaluation> evaluations) {
		super();
		this.nomStagiaire = nomStagiaire;
		this.prenomStagiaire = prenomStagiaire;
		this.emailStagiaire = emailStagiaire;
		this.telStagiaire = telStagiaire;
		this.adresseStagiaire = adresseStagiaire;
		this.evaluations=evaluations;
	}	
	
	public long getIdStagiaire() {
		return idStagiaire;
	}
	public long getId() {
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

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }
 
    public void addEvaluations(Set<Evaluation> evaluation) {
        this.evaluations = evaluation;
    }
     
    public void addEvaluation(Evaluation Evaluation) {
        this.evaluations.add(Evaluation);
    }
    
    public boolean addSession(Session session) 	
    {
		  boolean success=false;
		  
	        Evaluation evaluation = new Evaluation(session, this);
	        evaluations.add(evaluation);
	        session.getEvaluations().add(evaluation);
	        success=true;
	        return success;
    }
    
	  public boolean addSession(long idSession) {
		  boolean success=false;
		  DAOSession ds = new DAOSession();
		  Session session = ds.getSession(idSession);
			if   (session != null) {
		        Evaluation evaluation = new Evaluation(session, this);
		        evaluations.add(evaluation);
		        session.getEvaluations().add(evaluation);
		        success=true;
		  }
		  return success;
	    }   
    
	@Override
	public int hashCode() {
		return Objects.hash( idStagiaire);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		return idStagiaire == other.idStagiaire;
	}
	
	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + idStagiaire + ", nomStagiaire=" + nomStagiaire + ", prenomStagiaire="
				+ prenomStagiaire + ", emailStagiaire=" + emailStagiaire + ", telStagiaire=" + telStagiaire
				+ ", adresseStagiaire=" + adresseStagiaire + "]";
	}
	
}
