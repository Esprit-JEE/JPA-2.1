package com.esprit.jpa.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esprit.jpa.Main;
import com.esprit.jpa.model.CompositionChimique;
import com.esprit.jpa.model.ConditionDeConservation;
import com.esprit.jpa.model.Marchandise;
import com.esprit.jpa.model.Periode;
import com.esprit.jpa.model.ProduitAlimentaire;
import com.esprit.jpa.model.ProduitMenager;
import com.esprit.jpa.model.Promotion;

public class MarchandiseService {
    
    Logger logger = LoggerFactory.getLogger(MarchandiseService.class);
    
	
	public void ajouterProduitAlimentaire(ProduitAlimentaire pAlimentaire){
        // Create an EntityManager
        EntityManager manager = Main.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Save
            manager.persist(pAlimentaire);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        
	}


	public void ajouterCompositionChimique(CompositionChimique compositionChimique) {
        // Create an EntityManager
        EntityManager manager = Main.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Save
            manager.persist(compositionChimique);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }		
	}

	
	public void assignerConditionAProduit(ConditionDeConservation conditionDeConservation, ProduitAlimentaire produitAlimentaire) {
        // Create an EntityManager
        EntityManager manager = Main.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();
            
            ConditionDeConservation conditionDeConservationResult = manager.find(ConditionDeConservation.class, conditionDeConservation.getId());
            if(conditionDeConservationResult == null){
                manager.persist(conditionDeConservation);
                //manager.flush();
            }

            
            ProduitAlimentaire produitAlimentaireToUpdate = manager.find(ProduitAlimentaire.class, produitAlimentaire.getId());
            produitAlimentaireToUpdate.setConditionDeConservation(conditionDeConservation);
            // Save
            manager.merge(produitAlimentaireToUpdate);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }		
	}
	
	
	public void assignerComposantAProduitMenager(ProduitMenager pm, List<CompositionChimique> compositionChimiques) {
        // Create an EntityManager
        EntityManager manager = Main.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();
                        
            pm.setCompositionChimiques(compositionChimiques);
            manager.persist(pm);
            

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }		
	}
	
	
	public void ajouterPromotion(Promotion promo) {
        // Create an EntityManager
        EntityManager manager = Main.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();
            
            
           manager.persist(promo);
           //manager.flush();
            
            Marchandise omo = (Marchandise) manager.createQuery(
            		"SELECT m FROM Marchandise m WHERE m.nomMarchandise = :nomMarchandise")
            		.setParameter("nomMarchandise", "Omo")
            		.getSingleResult(); //Mauvaise pratique ?
            
            Periode periode =new Periode();
            periode.setDatedebut(java.sql.Date.valueOf(LocalDate.of(2015, Month.NOVEMBER, 01)));
            periode.setDateFin(java.sql.Date.valueOf(LocalDate.of(2015, Month.NOVEMBER, 22)));
            periode.setMarchandise(omo);
            periode.setPromotion(promo);            

            manager.persist(periode);
            
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }		
	}

}
