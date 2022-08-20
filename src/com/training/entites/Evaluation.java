package com.training.entites;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.training.util.EvaluationId;

@Entity(name = "Evaluation")
@Table(name="Evaluation")
@IdClass(EvaluationId.class)
public class Evaluation {
 
    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSession")
    private Session session;
    
    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdStagiare")
	private Stagiaire stagiaire;
	@Column
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
		public Evaluation(Stagiaire stagiaire,		Session session) {
			super();
			this.stagiaire = stagiaire;
			this.session = session;
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
		@Override
		public int hashCode() {
			return Objects.hash(session, stagiaire);
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
			return session == other.session && stagiaire == other.stagiaire;
		} 

		
}
