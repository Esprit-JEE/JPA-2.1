package com.esprit.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esprit.jpa.model.CompositionChimique;
import com.esprit.jpa.model.ConditionDeConservation;
import com.esprit.jpa.model.ProduitAlimentaire;
import com.esprit.jpa.model.ProduitMenager;
import com.esprit.jpa.model.Promotion;
import com.esprit.jpa.service.MarchandiseService;

public class Main {
 
    Logger logger = LoggerFactory.getLogger(Main.class);
    
    // create an EntityManagerFactory.
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("persistenceUnitName");

	public static void main(String[] args) {
		
//		StudentService studentService = new StudentService(ENTITY_MANAGER_FACTORY);
//
//		//logger.info("create Students");
//		studentService.create(1, "Asma", 22);
//		studentService.create(2, "Mohamed", 20);
//		studentService.create(3, "Tasnim", 25);
//
//        //logger.info("Update the age of Mohamed");
//        studentService.upate(2, "Mohamed", 25);
//
//        //logger.info("Delete Asma");
//        studentService.delete(1);
//
////		logger.info("All students : ");
//		List<Student> students = studentService.readAll();
//		if (students != null) {
//			for (Student stu : students) {
////				logger.info(stu.toString());
//			}
//		}
//
//		// NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
//		  ENTITY_MANAGER_FACTORY.close();
		
		
		MarchandiseService marchandiseService = new MarchandiseService();
		
		//Exercice 1
		ProduitAlimentaire lait = new ProduitAlimentaire();
		lait.setNomMarchandise("Lait");
		lait.setMarque("Delice");
		lait.setPrix(1.5d);
		lait.setBio(false);
		
		ProduitAlimentaire spaghetti = new ProduitAlimentaire();
		spaghetti.setNomMarchandise("Spaghetti");
		spaghetti.setMarque("epi d'or");
		spaghetti.setPrix(8.5d);
		spaghetti.setBio(true); // select *,bio+0 from marchandise; to display boolean value
		marchandiseService.ajouterProduitAlimentaire(lait);
		marchandiseService.ajouterProduitAlimentaire(spaghetti);
		

		//Exercice 2
		CompositionChimique hcio = new CompositionChimique();
		hcio.setComposant("HCIO");
		
		CompositionChimique h2o = new CompositionChimique();
		h2o.setComposant("H2O");
		
		CompositionChimique enzymes = new CompositionChimique();
		enzymes.setComposant("Enzymes");
		
		marchandiseService.ajouterCompositionChimique(hcio);
		marchandiseService.ajouterCompositionChimique(h2o);
		marchandiseService.ajouterCompositionChimique(enzymes);
		
		//Exercice 3
		ConditionDeConservation conditionDeConservationLait = new ConditionDeConservation();
		conditionDeConservationLait.setHumidite(0f);
		conditionDeConservationLait.setTemperature(10);
		
		ConditionDeConservation conditionDeConservationSpaghetti = new ConditionDeConservation();
		conditionDeConservationSpaghetti.setHumidite(0f);
		conditionDeConservationSpaghetti.setTemperature(25);
		
		marchandiseService.assignerConditionAProduit(conditionDeConservationLait, lait);
		marchandiseService.assignerConditionAProduit(conditionDeConservationSpaghetti, spaghetti);
		
		//Exercice 4
		ProduitAlimentaire yaourt = new ProduitAlimentaire();
		yaourt.setNomMarchandise("Yaourt");
		yaourt.setMarque("Delice");
		yaourt.setPrix(0.35d);
		yaourt.setBio(false);
		marchandiseService.ajouterProduitAlimentaire(yaourt);
		marchandiseService.assignerConditionAProduit(conditionDeConservationLait, yaourt);
		
		//Exercice 5
		ProduitMenager javel = new ProduitMenager();
		javel.setMarque("JUDY");
		javel.setNomMarchandise("Javel");
		javel.setPrix(2d);
		javel.setToxique(true);
		
		List<CompositionChimique> compositionChimiquesJavel = new ArrayList<CompositionChimique>();
		compositionChimiquesJavel.add(hcio);
		compositionChimiquesJavel.add(h2o);
		
		ProduitMenager omo = new ProduitMenager();
		omo.setMarque("Nadhif");
		omo.setNomMarchandise("Omo");
		omo.setPrix(4d);
		omo.setToxique(false);
		
		List<CompositionChimique> compositionChimiquesOmo = new ArrayList<CompositionChimique>();
		compositionChimiquesOmo.add(enzymes);
		compositionChimiquesOmo.add(h2o);
		
		marchandiseService.assignerComposantAProduitMenager(javel, compositionChimiquesJavel);
		marchandiseService.assignerComposantAProduitMenager(omo, compositionChimiquesOmo);

		
		//Exercice 6
		Promotion promo = new Promotion();
		promo.setTaux(0.5f);
		marchandiseService.ajouterPromotion(promo);
		
		
		//Exercice 7
		marchandiseService.nbreProduitParTemperature(5);
		
		//

		
		ENTITY_MANAGER_FACTORY.close();
    }


}