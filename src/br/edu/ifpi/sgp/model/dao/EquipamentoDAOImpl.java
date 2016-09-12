package br.edu.ifpi.sgp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.edu.ifpi.sgp.model.entity.Equipamento;

public class EquipamentoDAOImpl implements EquipamentoDAO {

	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();
	
	@Override
	public void adicionarEquipamento(Equipamento e) {
		// TODO Auto-generated method stub
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			JPAConexao.closeEntityManager();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipamento> listarEquipamentos() {
		return (List<Equipamento>)entityManager.createQuery("from Equipamento e").getResultList();
	}
	
	public void removerEquipamento(Equipamento e){
		try{
			entityManager.getTransaction().begin();
			Equipamento aSerApagado = entityManager.find(Equipamento.class,e.getId());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			JPAConexao.closeEntityManager();
		}
	}

}
