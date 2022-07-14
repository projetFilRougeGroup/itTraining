/**
 * 
 */
package com.training.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.training.util.JpaUtil;
import com.training.entites.Messages;
import com.training.entites.Formation;


public class DAOFormation {

	
public boolean addFormation(String nomFormation, String referenceFormation, String prerequisFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation, int dureeFormation, String domaineFormation) 
{
		
		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
	    boolean success=false;

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		// 3 : Instanciation Objet(s) métier (s)
		Formation formation = new Formation(nomFormation, referenceFormation, prerequisFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation, dureeFormation, domaineFormation);
		
		formation.setNomFormation(nomFormation);
		formation.setReferenceFormation(referenceFormation);
		
		
	
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		 
		
		em.persist(formation);
		
		
		// 5 : Fermeture transaction 
		tx.commit();
	
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
		// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
		//Donc, pense bien à ce qu'elle soit la dernière action de votre application
		//JpaUtil.close();	
		
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return success;
	
	}

public Formation getFormation(String nomFormation) {
	
	Formation f = null;
	try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

	    f = em.find(Formation.class,nomFormation);
	 
		// Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();

		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	return f;
}

public boolean modifyFormation(long idFormation, String referenceFormation,String nomFormation,  String prerequisFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation, int dureeFormation, String domaineFormation) {
	boolean success = false;
	Connection con = null;
	try {
		Class.forName(Messages.getString("driver"));
		con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
				Messages.getString("password"));
		Statement stmt = con.createStatement();
		
		String sqlReferenceFormation = "UPDATE contacts SET ReferenceFormation = " + "'" + referenceFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlNomFormation = "UPDATE contacts SET nomFormation = " + "'" + nomFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlPrerequisFormation = "UPDATE contacts SET prérequisFormation = " + "'" + prerequisFormation + "'" + " WHERE idFormation = " + idFormation;

		
		String sqlPublicFormation = "UPDATE contacts SET PublicFormation = " + "'" + publicFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlObjectifsFormation = "UPDATE contacts SET ObjectifsFormation = " + "'" + objectifsFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlDetailsFormation = "UPDATE contacts SET DetailsFormation = " + "'" + detailsFormation + "'" + " WHERE idFormation = " + idFormation;
		
		

		String sqlChaptersFormation = "UPDATE contacts SET ChaptersFormation = " + "'" + chaptersFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlPriceFormation = "UPDATE contacts SET PriceFormation = " + "'" + priceFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlDureeFormation = "UPDATE contacts SET DureeFormation = " + "'" + dureeFormation + "'" + " WHERE idFormation = " + idFormation;
		String sqlDomaineFormation = "UPDATE contacts SET DomaineFormation = " + "'" + domaineFormation + "'" + " WHERE idFormation = " + idFormation;

		if (referenceFormation != "")
			stmt.executeUpdate(sqlReferenceFormation);
		if (nomFormation != "")
			stmt.executeUpdate(sqlNomFormation);
		if (prerequisFormation != "")
			stmt.executeUpdate(sqlPrerequisFormation);
		
		if (publicFormation != "")
			stmt.executeUpdate(sqlPublicFormation);
		if (objectifsFormation != "")
			stmt.executeUpdate(sqlObjectifsFormation);
		if (detailsFormation != "")
			stmt.executeUpdate(sqlDetailsFormation);
		
		if (chaptersFormation != "")
			stmt.executeUpdate(sqlChaptersFormation);
		
		if (priceFormation != 0)
			stmt.executeUpdate(sqlPriceFormation);
		if (dureeFormation != 0)
			stmt.executeUpdate(sqlDureeFormation);
		if (domaineFormation != "")
			stmt.executeUpdate(sqlDomaineFormation);

		success = true;
		stmt.close();
		con.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return success;
}

}
