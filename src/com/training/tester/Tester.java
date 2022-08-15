package com.training.tester;

import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Theme;
import com.training.services.ServiceFormation;

public class Tester {

	public static void main(String[] args) {
		final long serialVersionUID = 1L;
//tests SCRUDS
		ServiceFormation sf = new ServiceFormation();		
		//theme
//		sf.addTheme("Informatique" );
		System.out.println("1");
		Theme st= sf.GetTheme((long) 1);
		System.out.println("é");
	//	sf.addTheme("Developpement", 1);
		Theme themedev = new Theme ("Developpement");
		System.out.println("3");
		themedev.setSupertheme(st);
		st.getSoustheme().add(themedev);
		System.out.println("4");
		sf.addTheme(themedev);
		
		sf.addTheme("Modelisation", 1);
		sf.addTheme("Java", 2);
		sf.addTheme("Python", 2);
		sf.addTheme("c--", 2);
		sf.addTheme("Basic", 2);
		
		sf.supprimerTheme(7);
		
		Theme th_upd = sf.GetTheme((long) 6);
		th_upd.setNomTheme("C++");
		sf.modifierTheme(th_upd);
		//prereq
		
		sf.addPrerequis("dev", "quizz dev");
		sf.addPrerequis("dev JAVA", "quizz dev JAVA");
		
		//formation
		sf.addFormation("initiation dev java", "0B301", "dev", "dev java", "details formation 0B301",	"ch1, ch2, ch3", 4995, 5);
		sf.addFormation("initiation dev java", "0B303", "dev java", "dev java senior", "details formation OB303",	"ch1, ch2, ch3", 9995, 5);

		Formation ob301 = sf.getFormation((long) 1);		
		
		//add prerequis to formation (x)
		Prerequis pr1 = sf.GetPrerequis((long) 1);
		ob301.getFormationPrerequis().add(pr1);		
		
		//remove prerequis from formation
	//todo
		
		//add theme to formation
		Theme th1 = sf.GetTheme((long) 1);
		ob301.getTheme().add(th1);

		//remove theme from formation
		//todo
				
		
		//modifier formation
		sf.modifierFormation(ob301);
		
	
		
		//Session
		
		//enseignant
			//assignation()
		
		//Salle
		//reservation
		
		//stagiaires
		//evaluation


		
	}

}
