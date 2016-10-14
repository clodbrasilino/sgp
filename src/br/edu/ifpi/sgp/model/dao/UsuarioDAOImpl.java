package br.edu.ifpi.sgp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import br.edu.ifpi.sgp.model.entity.Usuario;

/**
 * @author Patrick
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	EntityManager entityManager;

	@Override
	public void adicionarUsuario(Usuario usuario) {
		try {
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		} finally {
			if (JPAConexao.isEntityManagerOpen())
				JPAConexao.closeEntityManager();
		}
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		try {
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			Usuario aSerApagado = buscarUsuarioPorId(usuario.getIdUsuario());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		} finally {
			if (JPAConexao.isEntityManagerOpen())
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
	public Usuario buscarUsuarioNomeSenha(String login, String siape) {
		try {
			entityManager.getTransaction().begin();
			Usuario usuario = (Usuario) entityManager
					.createQuery("SELECT u from Usuario u where u.login = :login and u.siape = :siape")
					.setParameter("login", login).setParameter("siape", siape).getSingleResult();
			return usuario;
		} catch (Exception e) {
			System.out.println("erro -> " + e.toString());
			return null;
		} finally {
			if (JPAConexao.isEntityManagerOpen())
				JPAConexao.closeEntityManager();
		}
	}

	@Override
	public List<Usuario> listaUsuario() {
		return null;
	}

	@Override
	public List<Usuario> pesquisarUsuario(String nome) {
		return null;
	}

	@Override
	public Long contador() {
		try {
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			Long count = entityManager.createQuery("select count(*) from Usuario u", Long.class).getSingleResult();
			return count; 
		}catch (Exception e) {
			return null;
		} finally {
			if (JPAConexao.isEntityManagerOpen())
				JPAConexao.closeEntityManager();
		}
	}
}
