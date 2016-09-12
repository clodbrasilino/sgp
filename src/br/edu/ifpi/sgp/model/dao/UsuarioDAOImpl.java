package br.edu.ifpi.sgp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.edu.ifpi.sgp.model.entity.Usuario;

/**
 * @author Patrick
 *
 */
public class UsuarioDAOImpl  implements UsuarioDAO{

	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();

	@Override
	public void adicionarUsuario(Usuario usuario) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			JPAConexao.closeEntityManager();
		}
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		try{
			entityManager.getTransaction().begin();
			Usuario aSerApagado = buscarUsuarioPorId(usuario.getIdUsuario());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			JPAConexao.closeEntityManager();
		}
	}

	@Override
	public boolean alterarUsuario(Usuario usuario) {
		return false;
	}

	@Override
	public Usuario buscarUsuarioPorId(long idUsuario) {
		return (Usuario) entityManager.find(Usuario.class, idUsuario);
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		
		return null;
	}

	@Override
	public List<Usuario> listaUsuario() {
		return null;
	}

	@Override
	public List<Usuario> pesquisarUsuario(String nome) {
		return null;
	}
}
