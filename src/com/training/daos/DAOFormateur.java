package com.training.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

import com.mysql.cj.protocol.Resultset;
import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.util.JpaUtil;


public class DAOFormateur {
	private static final Logger LOGGER = Logger.getLogger(Enseignant.class);
	
	
	public void addFormateur(long idEnseignant, String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String telEnseignant, String adresseEnseignant,String skil) {

		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx =  em.getTransaction();
			tx.begin();

			Enseignant prof = new Enseignant();
			prof.setAdresseEnseignant(adresseEnseignant);
			
			em.persist(prof);
			tx.commit();
			em.close();
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		public void addFormateur(Enseignant prof) {


			try {
				EntityManager em=JpaUtil.getEmf().createEntityManager();
				EntityTransaction tx =  em.getTransaction();
				tx.begin();
				em.persist(prof);
				tx.commit();
				em.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

		
		
@SuppressWarnings("null")
public List<Enseignant> getAllFormateurs(String skill) {
		/*DataSource dataSource = null;
		List<Enseignant> prof=new ArrayList<>();
		 String query = 
				  "select * from enseignant where skill='"+skill+"' order by nomEnseignant";
				  System.out.println("query " + query);
				 
				  Connection conn = null;
				  try { @SuppressWarnings("unused")
				Statement st;
				  conn=dataSource.getConnection();
					st = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  ResultSet rs = null;
				try {
					 Statement st = null;
					rs = st.executeQuery(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				  try {
					while(rs.next()){
					 
					 
						prof.add(new Enseignant(rs.getLong(0),rs.getString(1),rs.getString(2),rs.getString(3),
								rs.getString(4),rs.getString(5),rs.getString(6)));
					  
					  System.out.println("prof :: "+prof);
					 
					  }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		
		
		
		
		return prof;}*/
	
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("");
		@SuppressWarnings("unchecked")
		List<Enseignant> formateur = (List<Enseignant>) em.createQuery(
				"SELECT f FROM Enseignant f where f.skill = ?0", Enseignant.class)
				.setParameter(0, skill)
			    
			    .getResultList();
		
		
		
		
		System.out.println(formateur);
		tx.commit();
		em.close();
		return formateur;
	}

@SuppressWarnings("null")
public Enseignant getAllFormateurs1(String idSession) {
	EntityManager em = JpaUtil.getEmf().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.createNativeQuery("");
	@SuppressWarnings("unchecked")
	Enseignant formateur =  em.createQuery(
			"SELECT f,s FROM Enseignant f join f.Session s on s.idsession where s.idSession = ?0", Enseignant.class)
			.setParameter(0, idSession)
		    
		    .getSingleResult();
	
	
	
	
	System.out.println(formateur);
	tx.commit();
	em.close();
	return formateur;
}


	public boolean deleteProf(long idEnseignant) {
		// TODO Auto-generated method stub
		
		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			Enseignant fSupp = em.find(Enseignant.class, idEnseignant);
//			em.persist(fSupp);

			em.remove(fSupp);
			tx.commit();
			em.close();
			success = true;

		} catch (Exception e) {
			LOGGER.error("BOOM!", e);
		
		
	}
		return success;
	

	
	
	

}}
