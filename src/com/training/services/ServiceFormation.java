package com.training.services;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.training.daos.DAOFormateur;
import com.training.daos.DAOFormation;
import com.training.daos.DAOPrerequis;
import com.training.daos.DAOSession;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Session;
import com.training.entites.Enseignant;

public class ServiceFormation {
	
	private static Logger logger = Logger.getLogger(ServiceFormation.class);

	
	public void addFormation(String nomFormation, String referenceFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation, int dureeFormation) 
	{
		DAOFormation df = new DAOFormation();
		df.addFormation(nomFormation, referenceFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation,priceFormation, dureeFormation);
		System.out.println("la formation à été bien ajouter !");
	}
	
	public List<Formation> rechercheFormation(String keyWord) {
		DAOFormation df = new DAOFormation();
		List<Formation> lForamtion = df.getAllFormation();
		List<Formation> result = lForamtion.stream().filter(f -> ((f.getNomFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getReferenceFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getDetailsFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getChaptersFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getObjectifsFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getPublicFormation()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());
		logger.debug("Nombre de formation trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
		
	}
	
	public List<Formation> afficherToutLesFormations(){
		DAOFormation df = new DAOFormation();
		List<Formation> lFormation=df.getAllFormation();
		logger.debug(lFormation);
		return lFormation;
	}
	
	public void modifierFormation(long idFormation, String referenceFormation,String nomFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation, int priceFormation, int dureeFormation)
	{
		DAOFormation df = new DAOFormation();
		df.modifyFormation(idFormation, referenceFormation,nomFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation, priceFormation, dureeFormation);
		System.out.println("la formation à été bien modifier");
	}
	
	public void supprimerFormation(long idFormation)
	{
		DAOFormation df = new DAOFormation();
		df.deleteFormation(idFormation);
		System.out.println(" la formation à bien été supprimer");
	}
	public void addPrerequis(String descriptionPrerequis, String quizz ) {
		
		DAOPrerequis df = new DAOPrerequis();
		df.addPrerequis(descriptionPrerequis,quizz);
		logger.info("la Prérequis à été bien ajouter !");
		
	}
	public List<Prerequis> afficherToutLesPrerequis() {
		DAOPrerequis dp = new DAOPrerequis();
		List<Prerequis> lPrerequis=dp.getAllPrerequis();
		logger.debug(lPrerequis);
		return lPrerequis;
	}

	public void supprimerPrerequis(long idPrerequis) {
		DAOPrerequis dp = new DAOPrerequis();
		dp.deletePrerequis(idPrerequis);
		logger.info("le Prérequis à été bien supprimer");
		
	}
	
	public void modifierPrerequis(long idPrerequis, String descriptionPrerequis,String quizz)
	{
		DAOFormation df = new DAOFormation();
		df.modifyPrerequis(idPrerequis, descriptionPrerequis,quizz);
		System.out.println("le prérequis à été bien modifier");
	}
	
	
	public Enseignant AjouterFormateur(String nomEnseignant, String prenomEnseignant, String emailEnseignant,	String telEnseignant, String adresseEnseignant,String skill) {
		
		DAOFormateur dp = new DAOFormateur();
		Enseignant enseignant= new Enseignant( nomEnseignant,prenomEnseignant, emailEnseignant, telEnseignant, adresseEnseignant ,skill);
		
//		, prenomEnseignant,  emailEnseignant,telEnseignant,  adresseEnseignant);
		dp.addFormateur(enseignant);
		logger.info("Added Professor in database");
		return enseignant;
		
	}
	public void AssignSession(long idsession) {
		Session session=new Session();
		Set<Session >sessions=new HashSet<>();
		Enseignant enseignant= new Enseignant();
		session.setIdSession(idsession);
		sessions.add(session);
		enseignant.setSessions(sessions);
	}
	
	
	public List<Enseignant> rechercheFormateur(String keyWord) {
		DAOFormateur df = new DAOFormateur();
		List<Enseignant> lForamteur = df.getAllFormateurs(keyWord);
		logger.info("Found Professor in database");
		return  lForamteur;
		
	}
	public Enseignant rechercheFormateur1(long keyWord) {
		DAOFormateur df = new DAOFormateur();
		Enseignant lForamteur = df.getAllFormateurs1(keyWord);
		logger.info("Found Professor in database");
		return  lForamteur;
		
	}
public Session AjouterSession(long idSession,String dateDebutSession, String dateFinSession, String price,long idEnseignant) {
		
		DAOSession ds = new DAOSession();
		
		Session session=new Session(idSession,dateDebutSession,dateFinSession,price,idEnseignant);
				ds.addSession(session);

//		, prenomEnseignant,  emailEnseignant,telEnseignant,  adresseEnseignant);
		
		logger.info("Added Session in database");
		return session;
	}

public List<Session> AfficherLesSessions() {
	// TODO Auto-generated method stub
	return null;
}
	

}
