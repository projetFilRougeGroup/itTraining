package com.training.services;


import com.training.daos.DAOFormation;
import com.training.entites.Formation;

public class ServiceFormation {

	
	public void addFormation(String nomFormation, String referenceFormation, String prerequisFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation, int dureeFormation, String domaineFormation) 
	{
		DAOFormation df = new DAOFormation();
		df.addFormation(nomFormation, referenceFormation, prerequisFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation, dureeFormation, domaineFormation);
		System.out.println("la formation à été bien ajouter !");
	}
	
	public void rechercheFormation(String nomFormation) {
		DAOFormation df = new DAOFormation();
		System.out.println(df.getFormation(nomFormation));
	}
	
	public void modifierFormation(long idFormation, String referenceFormation,String nomFormation,  String prerequisFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation, int priceFormation, int dureeFormation, String domaineFormation)
	{
		DAOFormation df = new DAOFormation();
		df.modifyFormation(idFormation, referenceFormation,nomFormation, prerequisFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation, priceFormation, dureeFormation, domaineFormation);
		System.out.println("la formation à été bien modifier");
	}
}
