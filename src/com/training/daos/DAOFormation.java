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
import com.training.entites.Session;
import com.training.entites.Stagiaire;
import com.training.entites.Theme;
import com.training.entites.Enseignant;
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
	 * Ajout d'une formation.
	 * @param formation
	 * @return
	 */
	public boolean addFormation(Formation formation) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
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

		Formation f = null;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			 f = em.find(Formation.class, idFormation);
			logger.info("Formation: "+ (f!=null?f.toString():" pas de formation trouvé pour l'id: " + idFormation));
			tx.commit();
			em.close();
		} catch (Exception e) {
			logger.error(e);
		}
		return f;
	}	

	public Formation getFormationfull(long idFormation) {
		Formation formation = new Formation();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			formation = (Formation) em.createQuery("SELECT f FROM Formation f where f.idFormation = ?0", Formation.class)
//			Formation formation = (Formation) em.createQuery("SELECT f FROM Formation f left outer join f.formationPrerequis p where f.idFormation = ?0", Formation.class)
					.setParameter(0, idFormation)
				    .getSingleResult();
			tx.commit();
			em.close();
			logger.info("Formation: "+ (formation!=null?formation.toString():" pas de formation trouvé pour l'id: " + idFormation));
		} catch (Exception e) {
			logger.error(e);
		}
		return formation;
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
		
		em.merge(formation);
		
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
		
		em.merge(prerequis);
		
		tx.commit();
		em.close();
		success = true;
		}catch (Exception e) {
			logger.error(e);
		}
		return success;
	}


	public boolean addTheme(String nomTheme, long idSupertheme) {

		boolean success=false;

			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Theme theme = new Theme(nomTheme);
			
			
			try {					
				Theme supertheme = em.find(Theme.class, idSupertheme);
				
		        if (supertheme != null) {
		        	theme.setSupertheme(supertheme);
					supertheme.getSoustheme().add(theme);
		        	em.persist(theme);
		        	em.merge(supertheme);
		        	success=true;
		        } else {
		        	success=false;
		        }
		        tx.commit();
		    } finally {
		        em.close();
		    }
			return success;
	}

	public boolean addTheme(Theme theme) {
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
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
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		NomTheme="'%"+NomTheme+"%'";
		List<Theme> ltheme = em.createQuery( "SELECT th from Theme th LEFT JOIN FETCH th.soustheme sth LEFT JOIN FETCH th.formation fth where th.nomTheme like ?0", Theme.class)
				.setParameter(0, NomTheme)
			    .getResultList();
		em.close();
		return ltheme;
	}



	public Theme getTheme(long idTheme) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();

		Theme theme = em.createQuery( "SELECT th from Theme th LEFT JOIN FETCH th.soustheme sth LEFT JOIN FETCH th.formation fth where th.idTheme = ?0", Theme.class)
				.setParameter(0, idTheme)
			    .getSingleResult();
		em.close();
		return theme;
	}


	public boolean deleteTheme(long idTheme) {

		
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			Theme tSupp = em.find(Theme.class, idTheme);
			if (tSupp != null) {
				if (tSupp.getSupertheme() != null) {
					Theme thSuper = em.find(Theme.class, tSupp.getSupertheme().getIdTheme());
					if (thSuper != null) {
						thSuper.getSoustheme().remove(tSupp);
						tSupp.setSupertheme(null);
						em.merge(thSuper);
					}
					
					em.remove(tSupp);
				}	
			}	
		
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			logger.error(e);
		}
		return success;
		
	}

	
	public boolean deleteTheme(Theme theme) {
		boolean success = false;
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Theme themetosupp = em.getReference(Theme.class, theme.getIdTheme());
			if (themetosupp != null) {
				em.remove(themetosupp);
				tx.commit();
				success = true;
			}
		} catch (Exception e) {
			tx.rollback();
			logger.error(e);
		}
		em.close();
		return success;
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

	
	public boolean linkTheme( long idTheme, long idThemesup) {

			boolean success = false;

			try {
				EntityManager em = JpaUtil.getEmf().createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();

				Theme th = em.find(Theme.class, idTheme);
				Theme thSup = em.find(Theme.class, idThemesup);

				th.setSupertheme(thSup);
				thSup.getSoustheme().add(th);
				em.merge(th);
				tx.commit();
				em.close();
				success = true;

			} catch (Exception e) {
				logger.error(e);
			}
			return success;
	}

	public boolean assignStagiaireToSession(long idStagiaire, long idSession )	 {
		boolean success=false;
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    try {					
	    Stagiaire stagiaire = em.find(Stagiaire.class, idStagiaire);
		Session session = em.find(Session.class, idSession);
		
        if (stagiaire != null && session != null) {
        	success = session.addStagiaire(stagiaire); // peut échouer si max atteint
        	stagiaire.addSession(session);
        	em.merge(stagiaire);
        	em.merge(session);

        } else {
        	success=false;
        }
        em.getTransaction().commit();
    } finally {
        em.close();
    }
	return success;
	}		
	
	
	public boolean unassignStagiaireToSession(long idStagiaire, long idSession )	 {
		boolean success=false;
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    try {					
	    Stagiaire stagiaire = em.find(Stagiaire.class, idStagiaire);
		Session session = em.find(Session.class, idSession);
		
        if (stagiaire != null && session != null) {
        	success = session.removeStagiaire(stagiaire); 
        	stagiaire.removeSession(session);
        	em.merge(stagiaire);
        	em.merge(session);
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
