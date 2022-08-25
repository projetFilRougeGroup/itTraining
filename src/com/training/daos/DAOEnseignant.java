package com.training.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.training.entites.Enseignant;
import com.training.entites.Session;
import com.training.entites.Theme;
import com.training.util.JpaUtil;

public class DAOEnseignant {
	
	
	
	public List<Enseignant> getAllEnseignant() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		em.createNativeQuery("");
		List<Enseignant> enseignants = em.createQuery(
			    "SELECT e FROM Enseignant e")
			    .getResultList();

		em.close();
		return enseignants;
	}
	
	public Enseignant getEnseignant(long idEnseignant) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Enseignant enseignant = em.find(Enseignant.class, idEnseignant);

		em.close();
		return enseignant;
	}
	
	public void addEnseignant(String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String telEnseignant, String adresseEnseignant) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Enseignant es = new Enseignant(nomEnseignant, prenomEnseignant, emailEnseignant,
			telEnseignant, adresseEnseignant);
		
		em.persist(es);
		
		tx.commit();
		em.close();
		
	}
	
	public void addEnseignant(Enseignant enseignant) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		em.persist(enseignant);
		
		tx.commit();
		em.close();
		
	}

	public void modifierEnseignant(long idEnseignant, String nomEnseignant, String prenomEnseignant,
			String emailEnseignant, String telEnseignant, String adresseEnseignant) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Enseignant es = (Enseignant) em.createQuery("SELECT e FROM Enseignant e where e.idEnseignant = ?0", Enseignant.class)
				.setParameter(0, idEnseignant)
			    .getSingleResult();
		
		es.setNomEnseignant(nomEnseignant);
		es.setPrenomEnseignant(prenomEnseignant);
		es.setEmailEnseignant(emailEnseignant);
		
		es.setTelEnseignant(telEnseignant);
		es.setAdresseEnseignant(adresseEnseignant);
		
		em.merge(es);
		
		tx.commit();
		em.close();	
	}
	
	public void modifierEnseignant(Enseignant enseignant) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		

		
		em.merge(enseignant);
		
		tx.commit();
		em.close();	
	}
	
	public void deleteEnseignant(long idEnseignant) {
	
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Enseignant ensSupp = em.find(Enseignant.class, idEnseignant);
		em.remove(ensSupp);
		
		tx.commit();
		em.close();
		
	}
	
	public void deleteEnseignant(Enseignant enseignant) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.remove(enseignant);
		
		tx.commit();
		em.close();
		
	}	
	
	
	public boolean assignEnseignantToSession(long idEnseignant, long idSession )	 {
					boolean success=false;
					
					EntityManager em = JpaUtil.getEmf().createEntityManager();
					EntityTransaction tx = em.getTransaction();
					tx.begin();
				    try {					
					Enseignant enseignant = em.find(Enseignant.class, idEnseignant);
					Session session = em.find(Session.class, idSession);
					
			        if (enseignant != null && session != null) {
			        	session.setEnseignant(enseignant);
			        	enseignant.getSessions().add(session);
			        	em.merge(enseignant);
			        	em.merge(session);
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
}
