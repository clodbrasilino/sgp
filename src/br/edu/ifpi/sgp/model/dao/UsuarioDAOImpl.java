package br.edu.ifpi.sgp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
			entityManager.close();
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
			entityManager.close();
		}
	}

	@Override
	public boolean alterarUsuario(Usuario usuario) {
		return false;
	}

	@Override
	public Usuario buscarUsuarioPorId(long idUsuario) {
		entityManager = JPAConexao.getEntityManager();
		return (Usuario) entityManager.find(Usuario.class, idUsuario);
	}

	@Override
	public Usuario buscarUsuarioNomeSenha(String login, String siape) {
		try {
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			Usuario usuario = (Usuario) entityManager
					.createQuery("SELECT u from Usuario u where u.login = :login and u.siape = :siape")
					.setParameter("login", login).setParameter("siape", siape).getSingleResult();
			entityManager.getTransaction().commit();
			return usuario;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			entityManager.close();
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
		Long count = -1L;
		try {
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			count = entityManager.createQuery("select count(u) from Usuario u", Long.class).getSingleResult();
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return count;
	}
}
