package com.training.entites;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.training.enums.City;

@Entity
public class Salle {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private long idSalle;
	
	private String codeSalle;
	private String adresseCentre;
	private String emailCentre;
	private int nombreDePlaces;
	///////////////////////////////////
	// Enum à regarder et à modifier//
	/////////////////////////////////
	private City city;
	/////////////////////////////////
	private Boolean salleEquipeeOrdi;
	private Boolean salleEquipeeProjecteur;
	
	@ManyToOne
	@JoinColumn(name="idReservation")
	private Reservation reserv;
	
	public Salle() {}
	public Salle(long idSalle, String codeSalle, String adresseCentre, String emailCentre, int nombreDePlaces,
			City city, Boolean salleEquipeeOrdi, Boolean salleEquipeeProjecteur) {
		super();
		this.idSalle = idSalle;
		this.codeSalle = codeSalle;
		this.adresseCentre = adresseCentre;
		this.emailCentre = emailCentre;
		this.nombreDePlaces = nombreDePlaces;
		this.city = city;
		this.salleEquipeeOrdi = salleEquipeeOrdi;
		this.salleEquipeeProjecteur = salleEquipeeProjecteur;
	}
	public Salle(String codeSalle, String adresseCentre, String emailCentre, int nombreDePlaces, City city,
			Boolean salleEquipeeOrdi, Boolean salleEquipeeProjecteur) {
		super();
		this.codeSalle = codeSalle;
		this.adresseCentre = adresseCentre;
		this.emailCentre = emailCentre;
		this.nombreDePlaces = nombreDePlaces;
		this.city = city;
		this.salleEquipeeOrdi = salleEquipeeOrdi;
		this.salleEquipeeProjecteur = salleEquipeeProjecteur;
	}
	
	public Salle(String codeSalle, String adresseCentre, String emailCentre, int nombreDePlaces, City city,
			Boolean salleEquipeeOrdi, Boolean salleEquipeeProjecteur, Reservation reserv) {
		super();
		this.codeSalle = codeSalle;
		this.adresseCentre = adresseCentre;
		this.emailCentre = emailCentre;
		this.nombreDePlaces = nombreDePlaces;
		this.city = city;
		this.salleEquipeeOrdi = salleEquipeeOrdi;
		this.salleEquipeeProjecteur = salleEquipeeProjecteur;
		this.reserv = reserv;
	}
	public long getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
	}
	public String getCodeSalle() {
		return codeSalle;
	}
	public void setCodeSalle(String codeSalle) {
		this.codeSalle = codeSalle;
	}
	public String getAdresseCentre() {
		return adresseCentre;
	}
	public void setAdresseCentre(String adresseCentre) {
		this.adresseCentre = adresseCentre;
	}
	public String getEmailCentre() {
		return emailCentre;
	}
	public void setEmailCentre(String emailCentre) {
		this.emailCentre = emailCentre;
	}
	public int getNombreDePlaces() {
		return nombreDePlaces;
	}
	public void setNombreDePlaces(int nombreDePlaces) {
		this.nombreDePlaces = nombreDePlaces;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Boolean getSalleEquipeeOrdi() {
		return salleEquipeeOrdi;
	}
	public void setSalleEquipeeOrdi(Boolean salleEquipeeOrdi) {
		this.salleEquipeeOrdi = salleEquipeeOrdi;
	}
	public Boolean getSalleEquipeeProjecteur() {
		return salleEquipeeProjecteur;
	}
	public void setSalleEquipeeProjecteur(Boolean salleEquipeeProjecteur) {
		this.salleEquipeeProjecteur = salleEquipeeProjecteur;
	}
	
	public Reservation getReserv() {
		return reserv;
	}
	public void setReserv(Reservation reserv) {
		this.reserv = reserv;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(adresseCentre, city, codeSalle, idSalle);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		return Objects.equals(adresseCentre, other.adresseCentre) && city == other.city
				&& Objects.equals(codeSalle, other.codeSalle) && idSalle == other.idSalle;
	}
	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", codeSalle=" + codeSalle + ", adresseCentre=" + adresseCentre
				+ ", emailCentre=" + emailCentre + ", nombreDePlaces=" + nombreDePlaces + ", city=" + city
				+ ", salleEquipeeOrdi=" + salleEquipeeOrdi + ", salleEquipeeProjecteur=" + salleEquipeeProjecteur
				+ ", reserv=" + reserv + "]";
	}	
}
