package com.training.entites;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity@Table(name="Sessions")
public class Session {

	
	@Column
	//@Id @GeneratedValue(generator="system-uuid")
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
	//@GenericGenerator(name = "generator", strategy = "increment")
    @Id
    
	private long idSession;
	private String dateDebutSession;
	private String dateFinSession;
	private String price;
	
	@ManyToOne
	//@JoinColumn(name="idFormation")
	private Formation formation;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	//@JoinColumn(name="idSession",referencedColumnName = "idSession")
	private Enseignant enseignant;
	
	@ManyToMany (cascade=CascadeType.MERGE,mappedBy="")
	//@JoinTable(name="SessionsFormations",
		//joinColumns=@JoinColumn(name="idSession"),
		//inverseJoinColumns=@JoinColumn(name="idStagiaire"))
	private Set<Stagiaire>	stagiaires = new HashSet<Stagiaire>();
	
	@OneToMany (cascade=CascadeType.MERGE, mappedBy="idReservation")
	private Set<Reservation> reservations = new HashSet<Reservation>();
	

	
	public Session() {
		
	}
	public Session(long idSession, String dateDebutSession, String dateFinSession, String price ,long idEnseignant) {
		super();
		this.idSession = idSession;
		this.dateDebutSession = dateDebutSession;
		this.dateFinSession = dateFinSession;
		this.price = price;
	
		
	}
	public Session(String dateDebutSession, String dateFinSession, String price) {
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
	public String getDateDebutSession() {
		return dateDebutSession;
	}
	public void setDateDebutSession(String dateDebutSession) {
		this.dateDebutSession = dateDebutSession;
	}
	public String getDateFinSession() {
		return dateFinSession;
	}
	public void setDateFinSession(String dateFinSession) {
		this.dateFinSession = dateFinSession;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
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
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebutSession=" + dateDebutSession + ", dateFinSession="
				+ dateFinSession + ", price=" + price + "]";
	}
	
}
