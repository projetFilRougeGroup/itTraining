package com.training.services;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.training.daos.DAOFormateur;
import com.training.daos.DAOFormation;
import com.training.daos.DAOPrerequis;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
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
	
	
	public void AjouterFormateur(String nomEnseignant, String prenomEnseignant, String emailEnseignant,	String telEnseignant, String adresseEnseignant,String skill) {
		
		DAOFormateur dp = new DAOFormateur();
		Enseignant enseignant= new Enseignant( nomEnseignant,prenomEnseignant, emailEnseignant, telEnseignant, adresseEnseignant ,skill);

//		, prenomEnseignant,  emailEnseignant,telEnseignant,  adresseEnseignant);
		dp.addFormateur(enseignant);
		logger.info("Added Professor in database");
		
	}
	
	public List<Enseignant> rechercheFormateur(String keyWord) {
		DAOFormateur df = new DAOFormateur();
		List<Enseignant> lForamteur = df.getAllFormateurs(keyWord);
		logger.info("Found Professor in database");
		return  lForamteur;
		
	}
	
	
}
