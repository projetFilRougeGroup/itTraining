use ITTRAINING;
insert into theme (idTheme, nomTheme, idSupertheme ) values ( 1, "informatique" ,         NULL);
insert into prerequis (descriptionPrerequis,quizz) values ("desc_prereq1","quizz_prereq1");
insert into formation (priceFormation,dureeFormation,chaptersFormation,detailsFormation,nomFormation,objectifsFormation,publicFormation,referenceFormation) values ( 999,5, "ch1:_outils,ch2:_variables ch3:_conditions,ch4:boucles","detail_formation_JAVA","JAVA(apprenez_a_programmer)","dev_java","dev_pas_java","OB101");
insert into formation (priceFormation,dureeFormation,chaptersFormation,detailsFormation,nomFormation,objectifsFormation,publicFormation,referenceFormation) values ( 999,5, "ch1:_outils,ch2:_variables ch3:_conditions,ch4:boucles","detail_formation_JAVA","JAVA(apprenez_a_programmer+)","dev_java","dev_pas_java","OB102");
insert into session (dateDebutSession, dateFinSession, idEnseignant, idFormation, price) values ("2022-08-14", "2022-08-18", null, 2, 9999);
insert into t_formation_prerequis (Formation_id,Prereq_id) values (1,1);
insert into t_formation_prerequis (Formation_id,Prereq_id) values (2,1);
insert into theme_formation (theme_idTheme, formation_idFormation) values (1,2);
