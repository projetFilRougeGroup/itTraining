package com.training.entites;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.training.daos.DAOSalle;
import com.training.daos.DAOSession;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "jourReserve", "idSalle", "idSession" }) })
public class Reservation {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReservation;
	private LocalDate jourReserve;
	
	@ManyToOne
	@JoinColumn(name="idSession")
	private Session session;
	
	@ManyToOne
	@JoinColumn(name="idSalle")
	private Salle salle;
	
	public Reservation() {
		
	}

	public Reservation(long idSalle,Long idSession, LocalDate jourReserve) {
		super();
		DAOSalle ds = new DAOSalle();
		Salle salle = ds.getSalle(idSalle);
		DAOSession df = new DAOSession();
		Session session = df.getSession(idSession);
		this.salle = salle;
		this.session = session;
		session.getReservations().add(this);

		this.jourReserve = jourReserve;
	}
	public Reservation(Salle salle, Session session, LocalDate jourReserve) {
		super();
		DAOSalle ds = new DAOSalle();
		this.salle = salle;
		this.session=session;
		this.jourReserve = jourReserve;
	}
	
	
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	public LocalDate getJourReserve() {
		return jourReserve;
	}
	public void setJourReserve(LocalDate jourReserve) {
		this.jourReserve = jourReserve;
	}

	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
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
