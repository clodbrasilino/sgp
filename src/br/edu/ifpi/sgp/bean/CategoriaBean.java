package br.edu.ifpi.sgp.bean;

import java.io.Serializable;
import java.util.List;

import br.edu.ifpi.sgp.model.dao.CategoriaDAOImpl;
import br.edu.ifpi.sgp.model.entity.Categoria;
import br.edu.ifpi.sgp.model.entity.Usuario;

public class CategoriaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private List<Usuario> listUsuario;
	private CategoriaDAOImpl catDAOImpl;
	private Categoria categoria;

	public void inicializar() {
		this.catDAOImpl = new CategoriaDAOImpl();
	}
	
	

}
