package com.training.services;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.training.daos.DAOEnseignant;
import com.training.daos.DAOFormation;
import com.training.daos.DAOPrerequis;
import com.training.daos.DAOSession;
import com.training.daos.DAOStagiaire;
import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Session;
import com.training.entites.Stagiaire;
import com.training.entites.Theme;

public class ServiceFormation {
	
	private static Logger logger = Logger.getLogger(ServiceFormation.class);

	
	public void addFormation(String nomFormation, String referenceFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation,int priceFormation, int dureeFormation) 
	{
		DAOFormation df = new DAOFormation();
		Formation formation = new Formation(nomFormation, referenceFormation, publicFormation, objectifsFormation, detailsFormation, chaptersFormation,priceFormation, dureeFormation);

		df.addFormation(formation);
		logger.info("la formation à été bien ajouter !");
	}
	
	public void addFormation(Formation formation)	{
		DAOFormation df = new DAOFormation();
		df.addFormation(formation);
		logger.info("la formation à été bien ajouter !");
	}
	
	public Formation getFormation(Long id) {
		
		DAOFormation df = new DAOFormation();
		Formation formation = df.getFormationfull(id); 
		return formation;
		
	}
	public boolean CheckFormation(Long id) {
		boolean success=false;
		
		DAOFormation df = new DAOFormation();
		Formation formation = df.getFormation(id);

		
		if (!formation.equals(null)) {
			logger.debug("Formation "+ formation.getNomFormation() + " trouvée");
			success=true;}
		return success;
	}	
	public List<Formation> rechercheFormation(String keyWord) {
		DAOFormation df = new DAOFormation();
		List<Formation> lForamtion = df.getAllFormation();
		List<Formation> result = lForamtion.stream().filter(f -> ((f.getNomFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getReferenceFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getDetailsFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getChaptersFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getObjectifsFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getPublicFormation()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());
		// check reference
		logger.debug("Nombre de formation trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
		
	}
	
	public List<Formation> afficherToutLesFormations(){
		DAOFormation df = new DAOFormation();
		List<Formation> lFormation=df.getAllFormation();
		logger.debug(lFormation);
		return lFormation;
	}
	
//	public Formation GetFormationFull(){
//		DAOFormation df = new DAOFormation();
//		List<Formation> lFormation=df.getAllFormation();
//		logger.debug(lFormation);
//		//return Formation;
//	}
	// renvoie formation + themes  + prerequ+ sessions
	
	public List<Formation> GetListeSimplifiéeFormations(){
		DAOFormation df = new DAOFormation();
		List<Formation> lFormation=df.getAllFormation();// id, theme, nom, reférence, durée
		logger.debug(lFormation);
		return lFormation;
	}
	
	public void modifierFormation(long idFormation, String referenceFormation,String nomFormation, String publicFormation, String objectifsFormation, String detailsFormation, String chaptersFormation, int priceFormation, int dureeFormation)
	{
		DAOFormation df = new DAOFormation();
		
		Formation formation = df.getFormation(idFormation);
		
		formation.setReferenceFormation(referenceFormation);
		formation.setNomFormation(nomFormation);
		
		formation.setPublicFormation(publicFormation);
		formation.setObjectifsFormation(objectifsFormation);
		formation.setDetailsFormation(detailsFormation);

		formation.setChaptersFormation(chaptersFormation);
		
		formation.setDureeFormation(dureeFormation);
		formation.setPriceFormation(priceFormation);

					
		df.modifyFormation(formation);
	}
	public void modifierFormation(Formation formation)
	{
		DAOFormation df = new DAOFormation();
		df.modifyFormation(formation);
		logger.info("la formation à été bien modifier");
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
	public void addPrerequis(Prerequis prereq ) {
		DAOPrerequis df = new DAOPrerequis();
		df.addPrerequis(prereq);
		logger.info("la Prérequis à été bien ajouter !");
	}	
	
	
	public List<Prerequis> afficherToutLesPrerequis() {
		DAOPrerequis dp = new DAOPrerequis();
		List<Prerequis> lPrerequis=dp.getAllPrerequis();
		logger.debug(lPrerequis);
		return lPrerequis;
	}
	public Prerequis GetPrerequis( Long IdPrerequis){
		DAOPrerequis dp = new DAOPrerequis();
		Prerequis prerequis=dp.getPrerequis(IdPrerequis);

		return prerequis;
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
		logger.info("le prérequis à été bien modifier");
	}
	public void addTheme(String nomTheme) 
	{
		Theme theme = new Theme(nomTheme);
		addTheme(theme);
		logger.info("Ajout d'un theme isolé !");
	}

	public void addTheme(String nomTheme, long IdSupertheme) 
	{
		DAOFormation df = new DAOFormation();

		df.addTheme(nomTheme,IdSupertheme);

		logger.info("Ajout d'un theme avec supertheme !");
	}	
	public void addTheme(Theme theme) 
	{
		DAOFormation df = new DAOFormation();
		df.addTheme(theme);
		logger.info("Ajout d'un theme !");
	}
	
	public List<Theme> rechercheTheme(String keyWord) {
		DAOFormation df = new DAOFormation();
		List<Theme> lTheme = df.getAllTheme();
		//List<Theme> result = lTheme.stream().filter(f -> f.getNomTheme().contains(keyWord) || f.getReferenceTheme().contains(keyWord) || f.getDetailsTheme().contains(keyWord) || f.getChaptersTheme().contains(keyWord) || f.getDomaineTheme().contains(keyWord) || f.getObjectifsTheme().contains(keyWord) || f.getPrerequisTheme().getDescriptionPrerequis().contains(keyWord) || f.getPublicTheme().contains(keyWord)).collect(Collectors.toList());
		logger.info("Nombre de Theme trouvé avec le mot clé " + keyWord + " : " + lTheme.size());
		return lTheme;
		
	}
	
	public List<Theme> afficherTousLesThemes(){
		DAOFormation df = new DAOFormation();
		List<Theme> lTheme=df.getAllTheme();
		logger.info(lTheme);
		return lTheme;
	}
	
	public Theme GetTheme( Long IdTheme){
		DAOFormation df = new DAOFormation();
		Theme theme=df.getTheme(IdTheme);

		return theme;
	}	
	
	public void modifierTheme(Theme theme) // version avec param
	{
		
		DAOFormation df = new DAOFormation();
		df.UpdateTheme(theme);
		logger.info("le Theme à été modifié");
	}
	
	public void supprimerTheme(long idTheme)
	{
		DAOFormation df = new DAOFormation();
		df.deleteTheme(idTheme);
		logger.info("le Theme à été supprimé");
	}
	public void lierThemes(long idTheme, long idThemesuper)
	{
		DAOFormation df = new DAOFormation();
		df.linkTheme(idTheme,idThemesuper);
		logger.info("le Theme à été supprimé");
	}	
	
	
	public void addStagiaire(String nomStagiaire, String prenomStagiaire, String emailStagiaire, String telStagiaire,
			String adresseStagiaire) {
		DAOStagiaire df = new DAOStagiaire();
		df.addStagiaire(nomStagiaire, prenomStagiaire, emailStagiaire, telStagiaire, adresseStagiaire);
		logger.info("le stagiaire à été bien ajouter !");
		
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
			logger.info("le stagiaire à été bien modifier");
		
	}

	public void supprimerStagiaire(long idStagiaire) {

		DAOStagiaire ds = new DAOStagiaire();
		ds.deleteStalgiaire(idStagiaire);
		logger.info("le stagiaire à été bien supprimer");
		
	}

	public List<Enseignant> rechercheEnseignant(String keyWord) {
		DAOEnseignant de = new DAOEnseignant();
		List<Enseignant> lEnseignant = de.getAllEnseignant();
		List<Enseignant> result = lEnseignant.stream().filter(f -> ((f.getNomEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getPrenomEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getTelEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getEmailEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getAdresseEnseignant()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());
		logger.debug("Nombre d'enseignant trouvé avec le mot clé "+keyWord+" : "+result.size());
		return result;
	}
	
	public List<Enseignant> rechercheFormateur(String skill) {
	DAOEnseignant de = new DAOEnseignant();
	List<Enseignant> lEnseignant = de.getAllEnseignant();
	List<Enseignant> result = lEnseignant.stream().filter(f -> ((f.getNomEnseignant()).toLowerCase()).contains(skill.toLowerCase()) || ((f.getPrenomEnseignant()).toLowerCase()).contains(skill.toLowerCase()) || ((f.getTelEnseignant()).toLowerCase()).contains(skill.toLowerCase()) || ((f.getEmailEnseignant()).toLowerCase()).contains(skill.toLowerCase()) || ((f.getAdresseEnseignant()).toLowerCase()).contains(skill.toLowerCase())).collect(Collectors.toList());
	logger.debug("Nombre d'enseignant trouvé avec le mot clé "+skill+" : "+result.size());
	return result;
}
	public void addEnseignant(String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String telEnseignant, String adresseEnseignant) {
		
		DAOEnseignant de = new DAOEnseignant();
		Enseignant enseignant= new Enseignant(nomEnseignant, prenomEnseignant,  emailEnseignant, telEnseignant, adresseEnseignant);
		de.addEnseignant(enseignant);
		
		logger.info("L'enseignant à été bien ajouté");
		
	}
	public void addEnseignant(Enseignant enseignant) {
		
		DAOEnseignant de = new DAOEnseignant();
		de.addEnseignant(enseignant);
		
		logger.info("L'enseignant à été bien ajouté");
		
	}
	public void modifierEnseignant(long idEnseignant, String nomEnseignant, String prenomEnseignant,
			String telEnseignant, String emailEnseignant, String adresseEnseignant) {
		
		DAOEnseignant de = new DAOEnseignant();
		Enseignant enseignant= new Enseignant(idEnseignant, nomEnseignant, prenomEnseignant,  emailEnseignant, telEnseignant, adresseEnseignant);
		de.modifierEnseignant(enseignant);
		logger.info("L'enseignant à été modifié !" );
	}
	public void modifierEnseignant(Enseignant enseignant) {
		
		DAOEnseignant de = new DAOEnseignant();
    	de.modifierEnseignant(enseignant);
		logger.info("L'enseignant à été modifié !" );
	}
	public void supprimerEnseignant(long idEnseignant) {
		
		DAOEnseignant de = new DAOEnseignant();
		de.deleteEnseignant(idEnseignant);
		logger.info("l'enseignant à été bien supprimé");
		
	}
	public void supprimerEnseignant(Enseignant enseignant) {
		
		DAOEnseignant de = new DAOEnseignant();
		de.deleteEnseignant(enseignant);
		logger.info("l'enseignant à été bien supprimé");
		
	}	
	
	public void addSession(Session session) 
	{
		DAOSession ds = new DAOSession();
		 ds.addSession(session);
		logger.info("Ajout d'une Session pour une formation!");

	}
	public void addSession(Long idFormation, LocalDate debut, LocalDate fin, float price) 
	{
		DAOSession ds = new DAOSession();
		ServiceFormation SF = new ServiceFormation();
		Formation formation = SF.getFormation(idFormation);
		
		Session session = new Session();

		session.setPrice(price);
		session.setDateDebutSession(debut);
		session.setDateFinSession(fin);
		
		session.setFormation(formation);
		formation.getSessions().add(session);
		

		 ds.addSession(session);
		logger.info("Ajout d'une Session pour une formation!");

	}	
	public Session afficherUneSession(Long idSession){
		DAOSession ds = new DAOSession();
		Session session=ds.getSession(idSession);
		logger.info(session);
		return session;
	}	
	
	public List<Session> AfficherLesSessions() {
		DAOSession ds = new DAOSession();
		List<Session> lSession = ds.getAllSessions();
		return lSession;
	}	

	public List<Session> rechercheSession(String keyWord) {
		DAOSession ds = new DAOSession();
		List<Session> lSession = ds.getAllSessions();
//		List<Formation> result = lFormation.stream().filter(f -> ((f.getNomFormation()).toLowerCase()).contains(keyWord.toLowerCase()) ||
		List<Session> result = lSession.stream().filter(f -> 
				((f.getDateDebutSession()).toString().toLowerCase()).contains(keyWord.toLowerCase()) ||
				((f.getDateFinSession()).toString().toLowerCase()).contains(keyWord.toLowerCase()) ||
				((String.valueOf(f.getPrice())).toLowerCase()).contains(keyWord.toLowerCase()) ||
				((f.getEnseignant().getNomEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) ||
				((f.getEnseignant().getPrenomEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) 
//				||
//				((f.g()).toLowerCase()).contains(keyWord.toLowerCase()) ||
//				((f.getPublicFormation()).toLowerCase()).contains(keyWord.toLowerCase())
				).collect(Collectors.toList());
		logger.debug("Nombre de formation trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
	}
	
	public void modifierSession(Session Session)
	{
		
		DAOSession ds = new DAOSession();
		ds.UpdateSession(Session);
		logger.info("le Session à été modifié");
	}
	
	public void supprimerSession(long idSession)
	{
		DAOSession ds = new DAOSession();
		ds.deleteSession(idSession);
		logger.info("le Session à été supprimé");
	}
	
	//assigne Enseignant a la session 
		// ne vérifie PAS la certification
	public boolean assignerEnseignant (long idEnseignant,long idSession) {
		
		boolean success = false;
		DAOEnseignant de = new DAOEnseignant();
		
		// check enseignant existe, 
		// check session existe 
		success = de.assignEnseignantToSession(idEnseignant,idSession);
		logger.info("Enseignant" + idEnseignant + "assigné a session " + idSession);
		
		return success;
	}
	
	public boolean certifierEnseignant (long idEnseignant,long idFormation) {
	// stub, to do
	return false;
	}
	
}
