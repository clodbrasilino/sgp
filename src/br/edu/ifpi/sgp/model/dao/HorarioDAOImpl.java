/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.DiaEHora;
import br.edu.ifpi.sgp.model.entity.Horario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Agustin
 */
public class HorarioDAOImpl implements HorarioDAO{
    
	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();

    @Override
    public void adicionarHorario(Horario h) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(h);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public Horario selecionarHorario(DiaEHora d) {

        return entityManager.createNamedQuery("select d from Horario d where diaEHora = :diaEHora", Horario.class)
                .setParameter("diaEHora", d)
                .getSingleResult();
        
    }

    @Override
    public List<Horario> listarHorario() {
        
        return (List<Horario>) entityManager.createNamedQuery("select d from Horario d = :diaEHora");
        
    }

    @Override
    public void AlterarHorario(Horario h) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(h);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public void removerHorario(Horario h) {
		try{
			entityManager.getTransaction().begin();
			Horario aSerApagado = entityManager.find(Horario.class,h.getDiaHora());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

    }
    
    
}
