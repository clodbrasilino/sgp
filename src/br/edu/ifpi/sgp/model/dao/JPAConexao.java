package br.edu.ifpi.sgp.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConexao {

		private static final EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("sgp");

		private static EntityManager ems = emf.createEntityManager();

		/*
		 * Obtém o EntityManager vinculado à  Thread atual. Se ele ainda não
		 * existir, é criado e depois, vinculado à Thread atual.
		 */
		public static EntityManager getEntityManager() {
			if(!ems.isOpen()) ems = emf.createEntityManager();
			return ems;
		}

		/*
		 *  Fecha o EntityManager atrelado à  Thread atual e retira-o da ThreadLocal.
		 */
		public static void closeEntityManager() {
			ems.close();
		}
		
		public static boolean isEntityManagerOpen(){
			return ems.isOpen();
		}

	}