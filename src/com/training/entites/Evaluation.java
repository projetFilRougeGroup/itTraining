package com.training.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.training.util.EvaluationId;

@Entity
@Table(name="Session_Stagiaire")
@IdClass(EvaluationId.class)
public class Evaluation {
	@Id
	private long idStagiaire;
	@Id
	private long idSession;
	@Column
	private int accueil;
	@Column
	private int salle;
	@Column
	private int support;
	@Column
	private int Enseignant;
		
	
	 @ManyToOne
	 @PrimaryKeyJoinColumn(name="idStagiaire", referencedColumnName="idStagiaire")
	 private Session session;

	 @ManyToOne
	 @PrimaryKeyJoinColumn(name="idSession", referencedColumnName="idSession")	
	 private Stagiaire stagiaire;


	 
	 //constructeur
		public Evaluation() {
			super();

		} 
		public Evaluation(long idStagiaire, long idSession) {
			super();
			this.idStagiaire = idStagiaire;
			this.idSession = idSession;
		}
		public long getIdStagiaire() {
			return idStagiaire;
		}
		public void setIdStagiaire(long idStagiaire) {
			this.idStagiaire = idStagiaire;
		}
		public long getIdSession() {
			return idSession;
		}
		public void setIdSession(long idSession) {
			this.idSession = idSession;
		}
		public int getAccueil() {
			return accueil;
		}
		public void setAccueil(int accueil) {
			this.accueil = accueil;
		}
		public int getSalle() {
			return salle;
		}
		public void setSalle(int salle) {
			this.salle = salle;
		}
		public int getSupport() {
			return support;
		}
		public void setSupport(int support) {
			this.support = support;
		}
		public int getEnseignant() {
			return Enseignant;
		}
		public void setEnseignant(int enseignant) {
			Enseignant = enseignant;
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

}
