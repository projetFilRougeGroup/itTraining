package com.training.entites;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Session {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSession;
	private LocalDate dateDebutSession;
	private LocalDate dateFinSession; // champs calculé datedébut 
	private float price;
//	private int nb_mini;
//	private int nb_max;
// 	private Lieux lieu_session //(dont distancielle), la session est créée pour un lieu, la résa salle doit suivre
	
	@ManyToOne
	@JoinColumn(name="idFormation")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="idEnseignant")
	private Enseignant enseignant;
	
	@OneToMany (cascade=CascadeType.PERSIST)
	private Set<Stagiaire>	stagiaires;
	
	@OneToMany (cascade=CascadeType.PERSIST, mappedBy="idReservation")
	private Set<Reservation> reservations = new HashSet<Reservation>();

	
	public Session() {
		
	}
	public Session(long idSession, LocalDate dateDebutSession, LocalDate dateFinSession, float price) {
		super();
		this.idSession = idSession;
		this.dateDebutSession = dateDebutSession;
		this.dateFinSession = dateFinSession;
		this.price = price;
	}
	public Session(LocalDate dateDebutSession, LocalDate dateFinSession, float price) {
		super();
		this.dateDebutSession = dateDebutSession;
		this.dateFinSession = dateFinSession;
		this.price = price;
	}
	public long getIdSession() {
		return idSession;
	}
	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}
	public LocalDate getDateDebutSession() {
		return dateDebutSession;
	}
	public void setDateDebutSession(LocalDate dateDebutSession) {
		this.dateDebutSession = dateDebutSession;
	}
	public LocalDate getDateFinSession() {
		return dateFinSession;
	}
	public void setDateFinSession(LocalDate dateFinSession) {
		this.dateFinSession = dateFinSession;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(idSession);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return idSession == other.idSession;
	}
	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebutSession=" + dateDebutSession + ", dateFinSession="
				+ dateFinSession + ", price=" + price + "]";
	}
	
}
