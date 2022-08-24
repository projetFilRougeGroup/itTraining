package com.training.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.entites.Session;
import com.training.util.JpaUtil;

public class DAOSession {
	public void addSession(Session session) {

		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			em.persist(session);
			tx.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Session> getAllSessions()  {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		List<Session> LSession = em.createQuery(
			    "SELECT f FROM Session f")
			    .getResultList();
		tx.commit();
		em.close();
		return LSession;
	}
	
	@SuppressWarnings("unchecked")
	public List<Session> getSessions()  {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		List<Session> LSession = em.createQuery(
			    "SELECT f FROM Session f")
			    .getResultList();
		tx.commit();
		em.close();
		return LSession;
	}

	
	public Session getSession(long idSession) {
		Session session= new Session();
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();

			 session = em.find(Session.class, idSession);

			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}



	public boolean deleteSession(long idSession) {
		boolean success=false;
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    try {					
	    	Session session = em.find(Session.class, idSession);
        	if (session != null) {
        	em.remove(session);
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


	public boolean deleteSession(Session session) {
		boolean success = false;
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

	        	em.remove(session);
	        	// stub check
	        	success=true;
	        	
	    return success;
	}


	public boolean UpdateSession(Session session) {

			boolean success = false;
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

		        	em.merge(session);
		        	// stub check
		        	success=true;
			tx.commit();
			em.close();
		    return success;
		}
	
	public boolean setSessionFormation	(long idSession,long idFormation){
		boolean success=false;
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    try {					
	    	Session session = em.find(Session.class, idSession);
	    	Formation formation = em.find(Formation.class, idFormation);
        	if (session != null && formation != null ) {
        		formation.getSessions().add(session);
        		session.setFormation(formation);
        	em.merge(session);
        	em.merge(formation);
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
}
