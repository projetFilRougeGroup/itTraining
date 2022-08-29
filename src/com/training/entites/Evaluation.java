package com.training.entites;

import java.util.Objects;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.training.util.EvaluationId;

@Entity(name="Evaluation")
@Table(name="Evaluation")
public class Evaluation {
//	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EvaluationId primaryKey = new EvaluationId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("SessionId")
    @JoinColumn(name = "idSession")
	private Session session;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("StagiaireId")
    @JoinColumn(name = "idStagiaire")
	private Stagiaire stagiaire;

	@Column(name = "formation_recommande")
	private int f_recom;  
	
    
	@Column(name = "evaluation_accueil")
	private int accueil;
	@Column
	private int salle;
	

	@Column	private int f_programmesuivi;
	@Column	private int f_pertinenceprogramme;
	@Column	private int support;
	@Column	private int atelier;
	@Column	private int equilibre;
	
	@Column	private int duree; //. 1 trop court a 5 trop long

	@Column	private int EnseignantExpertise;
	@Column	private int EnseignantPedagogie;
	@Column	private int EnseignantRelation;
	@Column	private int Enseignant_relationgroupe;

	@Column	private int satisfaction; // 1 tres insatisfait  4 tres satisfait
	@Column	private boolean objectifAtteint;
	@Column	private boolean prerequisCorrect;
	@Column	private boolean autreProjet;
	@Column	private boolean demandeContact;
	@Column	private String comment;
	


	 //constructeur
		public Evaluation() {
			super();

		} 
	    public Evaluation(Session session,Stagiaire stagiaire) {
	        this.session = session;
	        this.stagiaire = stagiaire;
	        this.primaryKey = new EvaluationId(session.getId(), stagiaire.getId());
	    }
	    

	    public EvaluationId getPrimaryKey() {
	        return primaryKey;
	    }
	 
	    public void setPrimaryKey(EvaluationId primaryKey) {
	        this.primaryKey = primaryKey;
	    }
	

	 	    
		
		public Session getSession() {
			return session;
		}
		public void setSession(Session session) {
			this.session = session;
		}
		public Stagiaire getStagiaire() {
			return stagiaire;
		}
		public void setStagiaire(Stagiaire stagiaire) {
			this.stagiaire = stagiaire;
		}
		
		public int getaccueil() {
			return accueil;
		}
		public void setaccueil(int accueil) {
			this.accueil = accueil;
		}
		public int getsalle() {
			return salle;
		}
		public void setsalle(int salle) {
			this.salle = salle;
		}
		public int getsupport() {
			return support;
		}
		public void setsupport(int support) {
			this.support = support;
		}

		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((session == null) ? 0 : session.hashCode());
			result = prime * result + ((stagiaire == null) ? 0 : stagiaire.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Evaluation other = (Evaluation) obj;
			if (session == null) {
				if (other.session != null)
					return false;
			} else if (!session.equals(other.session))
				return false;
			if (stagiaire == null) {
				if (other.stagiaire != null)
					return false;
			} else if (!stagiaire.equals(other.stagiaire))
				return false;
			return true;
		}
		
}
