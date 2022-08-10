package com.training.services;



import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.training.daos.DAOFormation;
import com.training.daos.DAOPrerequis;
import com.training.daos.DAOStagiaire;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Stagiaire;

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

	public void addStagiaire(String nomStagiaire, String prenomStagiaire, String emailStagiaire, String telStagiaire,
			String adresseStagiaire) {
		DAOStagiaire df = new DAOStagiaire();
		df.addStagiaire(nomStagiaire, prenomStagiaire, emailStagiaire, telStagiaire, adresseStagiaire);
		System.out.println("le stagiaire à été bien ajouter !");
		
	}

	public List<Stagiaire> rechercheStagiaire(String keyWord) {
		DAOStagiaire df = new DAOStagiaire();
		List<Stagiaire> lStagiaire = df.getAllStagiaire();
		List<Stagiaire> result = lStagiaire.stream().filter(f -> ((f.getNomStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getPrenomStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getTelStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getEmailStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getAdresseStagiaire()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());
		logger.debug("Nombre de stagiaire trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
	}

	public void modifierStagiaire(long idStagiaire, String nomStagiaire, String prenomStagiaire, String telStagiaire,
			String emailStagiaire, String adresseStagiaire) {
			DAOStagiaire ds = new DAOStagiaire();
			ds.modifyStagiaire(idStagiaire, nomStagiaire,prenomStagiaire,telStagiaire, emailStagiaire,adresseStagiaire);
			System.out.println("le stagiaire à été bien modifier");
		
	}

	public void supprimerStagiaire(long idStagiaire) {

		DAOStagiaire ds = new DAOStagiaire();
		ds.deleteStalgiaire(idStagiaire);
		logger.info("le stagiaire à été bien supprimer");
		
	}
}
