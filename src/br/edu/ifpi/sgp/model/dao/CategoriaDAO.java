package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Categoria;

public interface CategoriaDAO {
	
	public boolean adicionarCategoria(Categoria categoria);
	
	public boolean removerCategoia(Categoria categoria);
	
	public Categoria buscarCategoriaPorId(long idCategoria);
	

}
