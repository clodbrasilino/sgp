package br.edu.ifpi.sgp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.sgp.model.entity.Equipamento;

public class EquipamentoDAOImpl implements EquipamentoDAO {

	EntityManager entityManager;
	
	@Override
	public void adicionarEquipamento(Equipamento e) {
		try{
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipamento> listarEquipamentos() {
		return (List<Equipamento>)entityManager.createQuery("from Equipamento e").getResultList();
	}
	
	public void removerEquipamento(Equipamento e){
		try{
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			Equipamento aSerApagado = entityManager.find(Equipamento.class,e.getId());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}

}
