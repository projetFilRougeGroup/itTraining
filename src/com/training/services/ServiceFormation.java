package com.training.services;



import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.training.daos.DAOFormation;
import com.training.daos.DAOPrerequis;
import com.training.entites.Formation;
import com.training.entites.Prerequis;

public class ServiceFormation {
	
	private static Logger logger = Logger.getLogger(ServiceFormation.class);

	
	public void addFormation(String nomFormation, String referenceFormation, String prerequisFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation, int dureeFormation, String domaineFormation) 
	{
		DAOFormation df = new DAOFormation();
		df.addFormation(nomFormation, referenceFormation, prerequisFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation,priceFormation, dureeFormation, domaineFormation);
		System.out.println("la formation à été bien ajouter !");
	}
	
	public List<Formation> rechercheFormation(String keyWord) {
		DAOFormation df = new DAOFormation();
		List<Formation> lForamtion = df.getAllFormation();
		List<Formation> result = lForamtion.stream().filter(f -> f.getNomFormation().contains(keyWord) || f.getReferenceFormation().contains(keyWord) || f.getDetailsFormation().contains(keyWord) || f.getChaptersFormation().contains(keyWord) || f.getDomaineFormation().contains(keyWord) || f.getObjectifsFormation().contains(keyWord) || f.getPrerequisFormation().contains(keyWord) || f.getPublicFormation().contains(keyWord)).collect(Collectors.toList());
		logger.debug("Nombre de formation trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
		
	}
	
	public List<Formation> afficherToutLesFormations(){
		DAOFormation df = new DAOFormation();
		List<Formation> lFormation=df.getAllFormation();
		logger.debug(lFormation);
		return lFormation;
	}
	
	public void modifierFormation(long idFormation, String referenceFormation,String nomFormation,  String prerequisFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation, int priceFormation, int dureeFormation, String domaineFormation)
	{
		DAOFormation df = new DAOFormation();
		df.modifyFormation(idFormation, referenceFormation,nomFormation, prerequisFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation, priceFormation, dureeFormation, domaineFormation);
		System.out.println("la formation à été bien modifier");
	}
	
	public void supprimerFormation(long idFormation)
	{
		DAOFormation df = new DAOFormation();
		df.deleteFormation(idFormation);
		logger.info(" la formation à bien été supprimer");
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
}
