package com.bank.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class JpaUtils {
	private static final String PERSISTENCE_UNIT_NAME = "JPA-PU";
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
    	
        
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            
        
        	entityManager = factory.createEntityManager();
           

        
        
        return entityManager;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
        
	
}
