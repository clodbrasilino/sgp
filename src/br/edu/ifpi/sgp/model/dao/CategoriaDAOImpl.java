package br.edu.ifpi.sgp.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.edu.ifpi.sgp.model.entity.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO{

	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();
	
	@Override
	public boolean adicionarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerCategoia(Categoria categoria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categoria buscarCategoriaPorId(long idCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
