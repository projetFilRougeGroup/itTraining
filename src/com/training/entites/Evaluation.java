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
	
	@Column(name = "evaluation_accueil")
	private int eval_accueil;
	@Column
	private int eval_salle;
	@Column
	private int eval_support;
	@Column
	private int eval_Enseignant;



	 
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
		
		public int getEval_accueil() {
			return eval_accueil;
		}
		public void setEval_accueil(int eval_accueil) {
			this.eval_accueil = eval_accueil;
		}
		public int getEval_salle() {
			return eval_salle;
		}
		public void setEval_salle(int eval_salle) {
			this.eval_salle = eval_salle;
		}
		public int getEval_support() {
			return eval_support;
		}
		public void setEval_support(int eval_support) {
			this.eval_support = eval_support;
		}
		public int getEval_Enseignant() {
			return eval_Enseignant;
		}
		public void setEval_Enseignant(int eval_Enseignant) {
			this.eval_Enseignant = eval_Enseignant;
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
