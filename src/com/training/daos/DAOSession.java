package com.training.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		// TODO Auto-generated method stub
		return null;
	}



	public boolean deleteSession(long idSession) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean deleteSession(Session session) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean UpdateSession(Session session) {
		// TODO Auto-generated method stub
		return false;
	}	
}
