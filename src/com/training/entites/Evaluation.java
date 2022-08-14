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
@Table(name="Session_Stagiare")
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
	 // Getteurs & Setteurs
	 // a faire
}
