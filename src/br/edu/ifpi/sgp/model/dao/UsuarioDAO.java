package br.edu.ifpi.sgp.model.dao;

import java.util.List;

import br.edu.ifpi.sgp.model.entity.Usuario;

public interface UsuarioDAO {
	
	public void adicionarUsuario (Usuario usuario);
	
	public void excluirUsuario (Usuario usuario);
	
	public boolean alterarUsuario (Usuario usuario);
	
	public Usuario buscarUsuarioPorId (long idUsuario);
	
	public Usuario buscarUsuario(Usuario usuario);
	
    public List<Usuario> listaUsuario();
    
    public List<Usuario> pesquisarUsuario(String nome);
    
}