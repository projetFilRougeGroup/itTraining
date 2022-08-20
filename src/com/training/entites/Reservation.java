package com.training.entites;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "jourReserve", "idSalle" }) })
public class Reservation {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReservation;
	private String jourReserve;
	
	@ManyToOne
	@JoinColumn(name="idSession")
	private Session session;
	
	@ManyToOne
	@JoinColumn(name="idSalle")
	private Salle salle;
	
	public Reservation() {
		
	}
	public Reservation(long idReservation, String jourReserve) {
		super();
		this.idReservation = idReservation;
		this.jourReserve = jourReserve;
	}
	public Reservation(String jourReserve) {
		super();
		this.jourReserve=jourReserve;
	}
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	public String getJourReserve() {
		return jourReserve;
	}
	public void setJourReserve(String jourReserve) {
		this.jourReserve = jourReserve;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idReservation, jourReserve, salle, session);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return idReservation == other.idReservation && Objects.equals(jourReserve, other.jourReserve)
				&& Objects.equals(salle, other.salle) && Objects.equals(session, other.session);
	}
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", jourReserve=" + jourReserve + "]";
	}
	
}
