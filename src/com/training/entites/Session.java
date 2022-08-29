package com.training.entites;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.training.daos.DAOFormation;
import com.training.daos.DAOStagiaire;
import com.training.enums.City;

@Entity
@Table(name = "Session")
public class Session {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)@Column(name = "ID_SESSION")	
	private long idSession;
	private String codeSession;
	private LocalDate dateDebutSession;
	private LocalDate dateFinSession; // champs calculé datedébut 
	private float price;

	//	private int nb_mini;
	private int nb_max;
 	private City lieu_session; //(dont distancielle), la session est créée pour un lieu, la résa salle doit suivre
	

	@ManyToOne
	@JoinColumn(name="idFormation")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="idEnseignant")
	private Enseignant enseignant;
	
    @OneToMany(
            mappedBy = "session",
            cascade = CascadeType.ALL
        )
	private Set<Evaluation>	evaluations = new HashSet<Evaluation>();
	
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
	public long getId() {
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

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluation(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public void addEvaluation(Evaluation evaluation) {
		this.evaluations.add(evaluation);
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

	
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}	
	
	  public boolean addStagiaire(Stagiaire stagiaire) {
		  boolean success=false;
		  if (this.getEvaluations().size() + 1 < this.nb_max) {
		  
	        Evaluation evaluation = new Evaluation(this, stagiaire);
	        evaluations.add(evaluation);
	        stagiaire.getEvaluations().add(evaluation);
	        success=true;
		  }
		  return success;
	    }

	  public boolean addStagiaire(long idStagiaire) {
		  boolean success=false;
		  if (this.getEvaluations().size() + 1 < this.nb_max) {
			  DAOStagiaire df = new DAOStagiaire();
			  Stagiaire stagiaire = df.getStagiaire(idStagiaire);
	        Evaluation evaluation = new Evaluation(this, stagiaire);
	        evaluations.add(evaluation);
	        stagiaire.getEvaluations().add(evaluation);
	        success=true;
		  }
		  return success;
	    }	  
	  
	    public boolean removeStagiaire(Stagiaire stagiaire) {
	    	boolean success=false;
	        for (Iterator<Evaluation> iterator = evaluations.iterator();
	             iterator.hasNext(); ) {
	        	Evaluation evaluation = iterator.next();
	 
	            if (evaluation.getSession().equals(this) &&
	            		evaluation.getStagiaire().equals(stagiaire)) {
	                iterator.remove();
	                evaluation.getStagiaire().getEvaluations().remove(evaluation);
	                evaluation.setSession(null);
	                evaluation.setStagiaire(null);
	                success=true;
	            }
	        }
	        return success;
	    }	
	
		public int getNb_max() {
			return nb_max;
		}
		public void setNb_max(int nb_max) {
			this.nb_max = nb_max;
		}	

		public String getCodeSession() {
			return codeSession;
		}
		public void setCodeSession(String codeSession) {
			this.codeSession = codeSession;
		}
		public City getLieu_session() {
			return lieu_session;
		}
		public void setLieu_session(City lieu_session) {
			this.lieu_session = lieu_session;
		}
		public void setEvaluations(Set<Evaluation> evaluations) {
			this.evaluations = evaluations;
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
