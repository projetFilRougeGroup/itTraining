package com.training.daos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.training.entites.Salle;
import com.training.entites.Session;
import com.training.entites.Theme;
import com.training.enums.City;
import com.training.util.JpaUtil;

public class DAOSalle {
	
	
	
	public List<Salle> getAllSalles() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		em.createNativeQuery("");
		List<Salle> Salles = em.createQuery(
			    "SELECT e FROM Salle e")
			    .getResultList();

		em.close();
		return Salles;
	}
	
	public Salle getSalle(long idSalle) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Salle salle = em.find(Salle.class, idSalle);

		em.close();
		return salle;
	}
	
	public void addSalle(String codeSalle,String adresseCentre, String emailCentre,int nombreDePlaces, City city,Boolean salleEquipeeOrdi,Boolean salleEquipeeProjecteur) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Salle es = new Salle( codeSalle, adresseCentre,  emailCentre, nombreDePlaces,  city, salleEquipeeOrdi, salleEquipeeProjecteur );
		
		em.persist(es);
		tx.commit();
		em.close();
		
	}
	
	public void addSalle(Salle salle) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		em.persist(salle);
		
		tx.commit();
		em.close();
		
	}

	public void modifierSalle(long idSalle,String codeSalle,String adresseCentre, String emailCentre,int nombreDePlaces, City city,Boolean salleEquipeeOrdi,Boolean salleEquipeeProjecteur) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Salle es = em.createQuery("SELECT e FROM Salle e where e.idSalle = ?0", Salle.class)
				.setParameter(0, idSalle)
			    .getSingleResult();
		
		
		es.setCodeSalle(codeSalle);
		es.setAdresseCentre(adresseCentre);
		es.setEmailCentre(emailCentre);
		es.setNombreDePlaces(nombreDePlaces);
		es.setCity(city);
		es.setSalleEquipeeOrdi(salleEquipeeOrdi);
		es.setSalleEquipeeProjecteur(salleEquipeeProjecteur);
		
		em.merge(es);
		
		tx.commit();
		em.close();	
	}
	
	public void modifierSalle(Salle salle) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(salle);
		
		tx.commit();
		em.close();	
	}
	
	public void deleteSalle(long idSalle) {
	
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Salle toSupp = em.find(Salle.class, idSalle);
		if ( toSupp != null) {
					em.remove(toSupp);
					
				}
		
		tx.commit();
		em.close();
		
	}
	
	public boolean deleteSalle(Salle salle) {
		boolean success = false;
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Salle salletosuppr =em.find(Salle.class, salle.getIdSalle());
		if (salletosuppr != null) {
			em.remove(salletosuppr);
			success=true;
		}

		tx.commit();
		em.close();
		
		return success;
	}	
	
	
	public boolean ReserveSalleFull(long idSalle, long idSession )	 {
					boolean success=false;
					
					EntityManager em = JpaUtil.getEmf().createEntityManager();
					EntityTransaction tx = em.getTransaction();
					tx.begin();
				    try {					
					Salle salle = em.find(Salle.class, idSalle);
					Session session = em.find(Session.class, idSession);
					
			        if (salle != null && session != null) {
			        	//session.setSalle(Salle); // implique réservation de la salle pour tout les jours
			        	//salle.getReserv().add(reserv)
			        	//.add(session);
			        	//em.merge(salle);
			        	//em.merge(session);
			        	System.out.println(" reservation a faire");
			        	success=true;
			        } else {
			        	success=false;
			        }
			        em.getTransaction().commit();
			    } finally {
			        em.close();
			    }
		return success;
		}	
	
	
	public boolean ReserveSalle(long idSalle,LocalDate dayreserv, long idSession )	 {
					boolean success=false;
					boolean reserv_salle=false;
					
					EntityManager em = JpaUtil.getEmf().createEntityManager();
					EntityTransaction tx = em.getTransaction();
					tx.begin();
				    try {					
					Salle salle = em.find(Salle.class, idSalle);
					Session session = em.find(Session.class, idSession);
					
			        if (salle != null && session != null) { 
			        	
//						reserv_salle= session.setSalle(Salle); // implique réservation de la salle pour 
//						
//			        	Salle.getSessions().add(session);
//			        	em.merge(Salle);
//			        	em.merge(session);
			        	System.out.println("reserv salle pour jour pour session");
			        	success=true;
			        } else {
			        	success=false;
			        }
			        em.getTransaction().commit();
			    } finally {
			        em.close();
			    }
		return success;
	}

		// returns long idSession if salle reserved, null if available)
		public long check_reserv(long idSalle,  LocalDate datereserv ) {
			long idsession;
			
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {					
					Salle salle = em.find(Salle.class, idSalle);
					
			if (salle != null) {
						System.out.println("check reserv salle idsalle on day d");
						idsession=1L;
				        } else {
				        	idsession=0;
				        }
				    } finally {
				        em.close();
			}			
						
		
			return idsession;
			}	
		
}
