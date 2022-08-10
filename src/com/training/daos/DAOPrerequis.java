package com.training.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;


import com.training.entites.Prerequis;
import com.training.util.JpaUtil;

public class DAOPrerequis {
	
	private static Logger logger = Logger.getLogger(DAOPrerequis.class);
	
	
	/**
	 * Méthode addPrerequis : pour l'ajout d'un prérequis
	 * @param descriptionPrerequis
	 * @param quizz
	 * @return
	 */
	
	public boolean addPrerequis(String descriptionPrerequis, String quizz) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Prerequis prerequis = new Prerequis(descriptionPrerequis,quizz);

			em.persist(prerequis);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;

	}


	public List<Prerequis> getAllPrerequis() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		List<Prerequis> prerequis = em.createQuery(
			    "SELECT f FROM Prerequis f")
			    .getResultList();
		tx.commit();
		em.close();
		return prerequis;
	}


	public boolean deletePrerequis(long idPrerequis) {
		// TODO Auto-generated method stub
		
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			Prerequis fSupp = em.find(Prerequis.class, idPrerequis);
//			em.persist(fSupp);

			em.remove(fSupp);
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			logger.error(e);
		}
		return success;
		
	}
	

}
