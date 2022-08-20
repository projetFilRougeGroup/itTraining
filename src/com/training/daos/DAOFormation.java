/**
 * 
 */
package com.training.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Hibernate;
import org.jboss.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.util.JpaUtil;
import com.training.entites.Messages;
import com.training.entites.Prerequis;
import com.training.entites.Theme;
import com.training.entites.Formation;


/**
 * C'est le DAO qui permet d'effectuer des opérations portant sur une formation dans la base de données.
 * @author <a href="https://github.com/projetFilRougeGroup/itTraining">it-training</a>
 *
 */

public class DAOFormation {

	private static Logger logger = Logger.getLogger(DAOFormation.class);

	/**
	 * Ajout d'une formation.
	 * @param nomFormation
	 * @param referenceFormation
	 * @param prerequisFormation
	 * @param publicFormation
	 * @param detailsFormation
	 * @param chaptersFormation
	 * @param priceFormation
	 * @param dureeFormation
	 * @return
	 */
	public boolean addFormation(String nomFormation, String referenceFormation, String publicFormation, String objectifsFormation, 
			String detailsFormation, String chaptersFormation,int priceFormation, int dureeFormation) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Formation formation = new Formation(nomFormation, referenceFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation,priceFormation, dureeFormation);

			em.persist(formation);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;

	}

	/**
	 * Récupére une formation
	 * @param idFormation
	 * @return
	 * WAS getFormation, but returns boolean. renamed CheckFormation
	 */
	public boolean checkFormation(long idFormation) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Formation f = em.find(Formation.class, idFormation);

			logger.info("Formation: "+ (f!=null?f.toString():" pas de formation trouvé pour l'id: " + idFormation));
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			logger.error(e);
		}
		return success;
	}
	/**
	 * Récupére une formation
	 * @param idFormation
	 * @return
	 */
	public Formation getFormation(long idFormation) {

		boolean success=false;
		Formation f = null;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			 f = em.find(Formation.class, idFormation);

			logger.info("Formation: "+ (f!=null?f.toString():" pas de formation trouvé pour l'id: " + idFormation));
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			logger.error(e);
		}
		return f;
	}	

	public Formation getFormationfull(long idFormation) {
		return null;
	}
	/**
	 * Suppression d'une formation
	 * @param idFormation
	 * @return
	 */
	public boolean deleteFormation(long idFormation) {
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			Formation fSupp = em.find(Formation.class, idFormation);

			em.remove(fSupp);
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			logger.error(e);
		}
		return success;
	}
	/**
	 * Afficher tout les formations 
	 * @return
	 */
	public List<Formation> getAllFormation() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		List<Formation> formations = em.createQuery(
			    "SELECT f FROM Formation f")
			    .getResultList();
		tx.commit();
		em.close();
		return formations;
	}
	

	/**
	 * Modification de la formation
	 * @param idFormation
	 * @param referenceFormation
	 * @param nomFormation
	 * @param prerequisFormation
	 * @param publicFormation
	 * @param objectifsFormation
	 * @param detailsFormation
	 * @param chaptersFormation
	 * @param priceFormation
	 * @param dureeFormation
	 * @param domaineFormation
	 * @return
	 */
	public boolean modifyFormation(long idFormation, String referenceFormation,String nomFormation, 
			String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation, int dureeFormation) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Formation formation = (Formation) em.createQuery("SELECT f FROM Formation f where f.idFormation = ?0", Formation.class)
				.setParameter(0, idFormation)
			    .getSingleResult();
		
		formation.setNomFormation(nomFormation);
		formation.setChaptersFormation(chaptersFormation);
		formation.setDetailsFormation(detailsFormation);
		
		formation.setDureeFormation(dureeFormation);
		formation.setObjectifsFormation(objectifsFormation);
		
		formation.setPriceFormation(priceFormation);
		formation.setPublicFormation(publicFormation);
		formation.setReferenceFormation(referenceFormation);
		
		em.persist(formation);
		
		tx.commit();
		em.close();
			
		return true;
	}

	public boolean modifyFormation(Formation formation) {
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(formation);
		
		tx.commit();
		em.close();
			
		return true;
	}	
	
	public boolean modifyPrerequis(long idFormation, String descriptionPrerequis,String quizz) {
		
		boolean success = false;
		try {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prerequis prerequis = (Prerequis) em.createQuery("SELECT p FROM Prerequis p where p.idPrerequis = ?0", Prerequis.class)
				.setParameter(0, idFormation)
			    .getSingleResult();
		
		prerequis.setDescriptionPrerequis(descriptionPrerequis);
		prerequis.setQuizz(quizz);
		
		em.persist(prerequis);
		
		tx.commit();
		em.close();
		success = true;
		}catch (Exception e) {
			logger.error(e);
		}
		return success;
	}


	public boolean addTheme(String nomTheme) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Theme theme = new Theme(nomTheme);
			System.out.println(" arg: "+ nomTheme+ ", theme.nom:" + theme.getNomTheme());
//			theme.setSupertheme(supertheme);
//			supertheme.getSousthemes().add(theme);
//			theme.setSousthemes(sousthemes);
			
			em.persist(theme);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	
//	@Override
//	public boolean addTheme(String nomTheme, Theme supertheme) {
//
//		boolean success=false;
//		Set<Theme> sousthemes = new HashSet<Theme>();
//		
//		success = addTheme(nomTheme, supertheme,sousthemes );
//		return success;	
//	}



	public boolean addTheme(Theme theme) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();

			EntityTransaction tx =  em.getTransaction();
			tx.begin();

//			theme.setSupertheme(supertheme);
//			supertheme.getSousthemes().add(theme);
//			theme.setSousthemes(sousthemes);
			
			em.persist(theme);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Theme> getAllTheme() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		List<Theme> LTheme = em.createQuery(
			    "SELECT f FROM Theme f")
			    .getResultList();
		tx.commit();
		em.close();
		return LTheme;
	}




	public List<Theme> getTheme(String NomTheme) {
		// TODO Auto-generated method stub
		return null;
	}



	public Theme getTheme(long idTheme) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();

		
		Theme theme = em.createQuery( "SELECT th from Theme th LEFT JOIN FETCH th.soustheme sth LEFT JOIN FETCH th.formation fth", Theme.class).getSingleResult();

	
//		Theme theme = em.find( Theme.class, idTheme);
//		Hibernate.initialize(theme.getSoustheme());
//		Hibernate.initialize(theme.getFormation());
		em.close();
		return theme;
	}


	public boolean deleteTheme(long idTheme) {
		// TODO Auto-generated method stub
		
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			Theme tSupp = em.find(Theme.class, idTheme);

			em.remove(tSupp);
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			logger.error(e);
		}
		return success;
		
	}

	
	public boolean deleteTheme(Theme theme) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean UpdateTheme(Theme theme) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			em.merge(theme);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}	
	
}
