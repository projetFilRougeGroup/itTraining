package com.training.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

import com.training.entites.Formation;
import com.training.entites.Session;
import com.training.entites.Stagiaire;
import com.training.util.JpaUtil;

public class DAOStagiaire {

	private static Logger logger = Logger.getLogger(DAOFormation.class);
	
	public boolean addStagiaire(String nomStagiaire, String prenomStagiaire, String emailStagiaire, String telStagiaire,
			String adresseStagiaire) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Stagiaire stagiaire = new Stagiaire(nomStagiaire, prenomStagiaire, emailStagiaire, telStagiaire, adresseStagiaire);

			em.persist(stagiaire);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean addStagiaire(Stagiaire stagiaire) {
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			em.persist(stagiaire);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}	
	
	public List<Stagiaire> getAllStagiaire() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		List<Stagiaire> stagiaires = em.createQuery("SELECT s FROM Stagiaire s").getResultList();
		
		tx.commit();
		em.close();
		return stagiaires;
	}
	
	public Stagiaire getStagiaire(Long idStagiaire) {
		boolean success= false;
		Stagiaire stagiaire= new Stagiaire();
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	    try {					
	    	stagiaire = em.find(Stagiaire.class, idStagiaire);
        	if (stagiaire != null  ) {
        	success=true;
        	} else {
        	success=false;
        	}
        	tx.commit();
	    } finally {
        em.close();
	    }
	    return stagiaire;
	}
	
	
	
	

	public boolean modifyStagiaire(long idStagiaire, String nomStagiaire, String prenomStagiaire, String telStagiaire,
			String emailStagiaire, String adresseStagiaire) {
		boolean success = false;
		try {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Stagiaire stagiaire = (Stagiaire) em.createQuery("SELECT s FROM Stagiaire s where s.idStagiaire = ?0", Stagiaire.class)
				.setParameter(0, idStagiaire)
			    .getSingleResult();
		
		stagiaire.setNomStagiaire(nomStagiaire);
		stagiaire.setPrenomStagiaire(prenomStagiaire);
		
		stagiaire.setTelStagiaire(telStagiaire);
		stagiaire.setEmailStagiaire(emailStagiaire);
		
		stagiaire.setAdresseStagiaire(adresseStagiaire);
		
		em.persist(stagiaire);
		
		tx.commit();
		em.close();
		success = true;
		}catch (Exception e) {
			logger.error(e);
		}
		return success;
	}
	
	public boolean modifyStagiaire(Stagiaire stagiaire) {
		boolean success = false;
		try {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.merge(stagiaire);
		
		tx.commit();
		em.close();
		success = true;
		}catch (Exception e) {
			logger.error(e);
		}
		return success;
	}
	
	
	public boolean deleteStagiaire(long idStagiaire) {
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			Stagiaire stagiaireSupp = em.find(Stagiaire.class, idStagiaire);

			em.remove(stagiaireSupp);
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			logger.error(e);
		}
		return success;
	}
	
	public boolean deleteStagiaire(Stagiaire stagiaireSupp) {
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.remove(stagiaireSupp);
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			logger.error(e);
		}
		return success;
	}
	
}
