package br.edu.ifpi.sgp.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConexao {

		private static EntityManagerFactory emf;

		public static EntityManager getEntityManager() {
			if(emf == null) emf = Persistence.createEntityManagerFactory("sgp");
			return emf.createEntityManager();
		}
}