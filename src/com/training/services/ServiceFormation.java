package com.training.services;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.training.daos.DAOEnseignant;
import com.training.daos.DAOFormation;
import com.training.daos.DAOPrerequis;
import com.training.daos.DAOSalle;
import com.training.daos.DAOSession;
import com.training.daos.DAOStagiaire;
import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Reservation;
import com.training.entites.Salle;
import com.training.entites.Session;
import com.training.entites.Stagiaire;
import com.training.entites.Theme;
import com.training.enums.City;

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
	
	public Formation getFormation(Long idFormation) {
		
		DAOFormation df = new DAOFormation();
		Formation formation = df.getFormationfull(idFormation); 
		return formation;
		
	}
	public boolean CheckFormation(Long idFormation) {
		boolean success=false;
		DAOFormation df = new DAOFormation();
		Formation formation = getFormation(idFormation);
		
		if (formation!=null) {
			logger.debug("Formation "+ formation.getNomFormation() + " trouvée");
			success=true;}
		return success;
	}	
	
	public List<Formation> rechercheFormation(String keyWord) {
		DAOFormation df = new DAOFormation();
		List<Formation> lFormation = df.getAllFormation();
		List<Formation> result = lFormation.stream().filter(f -> ((f.getNomFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getReferenceFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getDetailsFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getChaptersFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getObjectifsFormation()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getPublicFormation()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());
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
	
	public List<Prerequis> recherchePrerequis(String keyWord) {
		DAOPrerequis dp = new DAOPrerequis();
		List<Prerequis> lPrerequis=dp.getAllPrerequis();
		List<Prerequis> result = lPrerequis.stream().filter(f -> ((f.getDescriptionPrerequis()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getQuizz()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList()); 

		logger.debug("Nombre de Prerequis trouvés avec le mot clé " + keyWord + " : " + result.size());
		return result;
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
		List<Theme> result = lTheme.stream().filter(f -> ((f.getNomTheme()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());

		logger.info("Nombre de Theme trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
		
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
	public List<Theme> GetThemebyname( String nomTheme){
		DAOFormation df = new DAOFormation();
		List<Theme> ltheme=df.getTheme(nomTheme);

		return ltheme;
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
	
	public void supprimerTheme(Theme theme)
	{
		DAOFormation df = new DAOFormation();
		df.deleteTheme(theme);
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
		logger.info("le stagiaire à été bien ajouté !");
		
	}
	public void addStagiaire(Stagiaire stagiaire) {
		DAOStagiaire df = new DAOStagiaire();
		df.addStagiaire(stagiaire);
		logger.info("le stagiaire à été bien ajouté !");
		
	}
	public List<Stagiaire> rechercheStagiaire(String keyWord) {
		DAOStagiaire df = new DAOStagiaire();
		List<Stagiaire> lStagiaire = df.getAllStagiaire();
		List<Stagiaire> result = lStagiaire.stream().filter(f -> ((f.getNomStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getPrenomStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getTelStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getEmailStagiaire()).toLowerCase()).contains(keyWord.toLowerCase()) || ((f.getAdresseStagiaire()).toLowerCase()).contains(keyWord.toLowerCase())).collect(Collectors.toList());
		logger.debug("Nombre de stagiaire trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
	}
	public Stagiaire getStagiaire(long idStagiaire) {
		DAOStagiaire df = new DAOStagiaire();
		Stagiaire stagiaire = df.getStagiaire(idStagiaire);
		return stagiaire;
	}
	public void modifierStagiaire(long idStagiaire, String nomStagiaire, String prenomStagiaire, String telStagiaire,
			String emailStagiaire, String adresseStagiaire) {
			DAOStagiaire ds = new DAOStagiaire();
			ds.modifyStagiaire(idStagiaire, nomStagiaire,prenomStagiaire,telStagiaire, emailStagiaire,adresseStagiaire);
			logger.info("le stagiaire à été bien modifié");
		
	}

	public void supprimerStagiaire(long idStagiaire) {

		DAOStagiaire ds = new DAOStagiaire();
		ds.deleteStagiaire(idStagiaire);
		logger.info("le stagiaire à été bien supprimer");
		
	}

	public Enseignant getEnseignant(long idEnseignant) {
		DAOEnseignant de = new DAOEnseignant();
		Enseignant Enseignant = de.getEnseignant(idEnseignant);
		return Enseignant;
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
				((String.valueOf(f.getPrice())).toLowerCase()).contains(keyWord.toLowerCase())
//				||
//				((f.getEnseignant().getNomEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) ||
//				((f.getEnseignant().getPrenomEnseignant()).toLowerCase()).contains(keyWord.toLowerCase()) 
				).collect(Collectors.toList());
		logger.debug("Nombre de formation trouvé avec le mot clé " + keyWord + " : " + result.size());
		return result;
	}

	public Session getSession(long idSession) {
		DAOSession ds = new DAOSession();
		Session session = ds.getSession(idSession);
		return session;
	}	
	
	public void modifierSession(Session Session)
	{
		
		DAOSession ds = new DAOSession();
		ds.UpdateSession(Session);
		logger.info("la Session à été modifiée");
	}
	
	public void supprimerSession(long idSession)
	{
		DAOSession ds = new DAOSession();
		ds.deleteSession(idSession);
		logger.info("le Session à été supprimé");
	}
	
	// salles
	public void addSalle(Salle Salle) 
	{
		DAOSalle ds = new DAOSalle();
		 ds.addSalle(Salle);
		logger.info("Ajout d'une Salle pour une formation!");

	}
	public void addSalle(String codeSalle,String adresseCentre, String emailCentre,int nombreDePlaces, City city,Boolean salleEquipeeOrdi,Boolean salleEquipeeProjecteur) 
	{
		DAOSalle ds = new DAOSalle();
		Salle salle = new Salle( codeSalle, adresseCentre,  emailCentre, nombreDePlaces,  city, salleEquipeeOrdi, salleEquipeeProjecteur );
		ds.addSalle(salle);
		logger.info("Ajout d'une Salle pour une formation!");

	}	
	public Salle afficherUneSalle(Long idSalle){
		DAOSalle ds = new DAOSalle();
		Salle Salle=ds.getSalle(idSalle);
		logger.info(Salle);
		return Salle;
	}	
	
	public List<Salle> AfficherLesSalles() {
		DAOSalle ds = new DAOSalle();
		List<Salle> lSalle = ds.getAllSalles();
		return lSalle;
	}	

	public List<Salle> rechercheSalle(String keyWord) {
		DAOSalle ds = new DAOSalle();
		List<Salle> lSalle = ds.getAllSalles();
//nombreDePlaces salleEquipeeOrdi, salleEquipeeProjecteur champs non parcourus
				List<Salle> result = lSalle.stream().filter(f -> 
				((f.getCodeSalle().toLowerCase())).contains(keyWord.toLowerCase()) ||
				((f.getAdresseCentre().toLowerCase())).contains(keyWord.toLowerCase()) ||
				((f.getEmailCentre().toLowerCase())).contains(keyWord.toLowerCase()) ||
				((f.getCity().toString().toLowerCase())).contains(keyWord.toLowerCase())
				).collect(Collectors.toList());
				
		logger.debug("Nombre de salles trouvées avec le mot clé " + keyWord + " : " + result.size());
		return result;
	}

	public Salle getSalle(long idSalle) {
		DAOSalle ds = new DAOSalle();
		Salle Salle = ds.getSalle(idSalle);
		return Salle;
	}	
	
	public void modifierSalle(Salle Salle)
	{
		
		DAOSalle ds = new DAOSalle();
		ds.modifierSalle(Salle);
		logger.info("la Salle à été modifiée");
	}
	public void modifierSalle(long idSalle,String codeSalle,String adresseCentre, String emailCentre,int nombreDePlaces, City city,Boolean salleEquipeeOrdi,Boolean salleEquipeeProjecteur) { 
	
		
		DAOSalle ds = new DAOSalle();
		ds.modifierSalle(idSalle, codeSalle, adresseCentre,  emailCentre, nombreDePlaces,  city, salleEquipeeOrdi, salleEquipeeProjecteur );

		logger.info("la Salle à été modifiée");
	}	
	
	
	public void supprimerSalle(long idSalle)
	{
		DAOSalle ds = new DAOSalle();
		ds.deleteSalle(idSalle);
		logger.info("le Salle à été supprimée");
	}
	
	public void supprimerSalle(Salle salle)
	{
		DAOSalle ds = new DAOSalle();
		ds.deleteSalle(salle);
		logger.info("le Salle à été supprimée");
	}
	
	
	// Reservations
	public void addReservation(Reservation Reservation) 
	{
		DAOSalle ds = new DAOSalle();
		 ds.addReservation(Reservation);
		logger.info("Ajout d'une Reservation pour une formation!");

	}
	public void addReservation(long IdSalle, long IdSession, LocalDate dateRes ) 
	{
		DAOSalle ds = new DAOSalle();
		Reservation Reservation = new Reservation(IdSalle,IdSession,dateRes );
		ds.addReservation(Reservation);
		logger.info("Ajout d'une Reservation pour une formation!");

	}	
	public Reservation afficherUneReservation(Long idReservation){
		DAOSalle ds = new DAOSalle();
		Reservation Reservation=ds.getReservation(idReservation);
		logger.info(Reservation);
		return Reservation;
	}	
	
	public List<Reservation> AfficherLesReservations() {
		DAOSalle ds = new DAOSalle();
		List<Reservation> lReservation = ds.getAllReservations();
		return lReservation;
	}	

	public List<Reservation> rechercheReservation(String keyWord) {
		DAOSalle ds = new DAOSalle();
		List<Reservation> lReservation = ds.getAllReservations();
//nombreDePlaces ReservationEquipeeOrdi, ReservationEquipeeProjecteur champs non parcourus
				List<Reservation> result = lReservation.stream().filter(f -> 
				((f.getSalle().getCodeSalle().toLowerCase())).contains(keyWord.toLowerCase()) ||
				((f.getSession().getCodeSession().toLowerCase())).contains(keyWord.toLowerCase()) ||
				((f.getSession().getLieu_session().nameLowerCase())).contains(keyWord.toLowerCase()) ||
				((f.getSalle().getCity().nameLowerCase())).contains(keyWord.toLowerCase())
				).collect(Collectors.toList());
				
		logger.debug("Nombre de Reservations trouvées avec le mot clé " + keyWord + " : " + result.size());
		return result;
	}

	public Reservation getReservation(long idReservation) {
		DAOSalle ds = new DAOSalle();
		Reservation Reservation = ds.getReservation(idReservation);
		return Reservation;
	}	
	
	public void modifierReservation(Reservation Reservation)
	{
		
		DAOSalle ds = new DAOSalle();
		ds.modifierReservation(Reservation);
		logger.info("la Reservation à été modifiée");
	}
	public void modifierReservation(long idReservation,Salle salle, Session session, LocalDate JourReserve) { 

		
		DAOSalle ds = new DAOSalle();
		ds.modifierReservation(idReservation, salle, session,  JourReserve);

		logger.info("la Reservation à été modifiée");
	}	

	public void supprimerReservation(long idReservation)
	{
		DAOSalle ds = new DAOSalle();
		ds.deleteReservation(idReservation);
		logger.info("le Reservation à été supprimée");
	}
	
	public void supprimerReservation(Reservation Reservation)
	{
		DAOSalle ds = new DAOSalle();
		ds.deleteReservation(Reservation);
		logger.info("le Reservation à été supprimée");
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

	
	
	public boolean inscrireStagiaire (long idStagiaire,long idSession) {
		
		boolean success = false;
		DAOFormation df = new DAOFormation();
		
		// check enseignant existe, 
		// check session existe 
		success = df.assignStagiaireToSession(idStagiaire,idSession);
		logger.info("Enseignant" + idStagiaire + "assigné a session " + idSession);
		
		return success;
	}	
	
	public boolean deinscrireStagiaire (long idStagiaire,long idSession) {
		
		boolean success = false;
		DAOFormation df = new DAOFormation();
		
		// check enseignant existe, 
		// check session existe 
		success = df.unassignStagiaireToSession(idStagiaire,idSession);
		logger.info("Enseignant" + idStagiaire + "désassigné de session " + idSession);
		
		return success;
	}	
	
	public boolean certifierEnseignant (long idEnseignant,long idFormation) {
	// stub, to do
	return false;
	}
	
	public boolean setSessionFormation (long idSession,long idFormation) {
		boolean success;
		DAOSession ds = new DAOSession();
		success = ds.setSessionFormation(idSession,idFormation );
		return success;
		}
	
}
