/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Agustin
 */
public class TurmaDAOImpl implements TurmaDAO{
	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();


    @Override
    public void adicionarTurma(Turma t) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public Turma selecionarTurma(Long t) {

        return entityManager.createNamedQuery("select t from Turma t where idTurma = :idTurma", Turma.class)
                .setParameter("idTurma", t)
                .getSingleResult();
        
    }

    @Override
    public List<Turma> listarTurma() {
        
        return (List<Turma>) entityManager.createNamedQuery("select t from Turma t = :idTurma");
        
    }

    @Override
    public void AlterarTurma(Turma t) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(t);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public void removerTurma(Turma t) {
		try{
			entityManager.getTransaction().begin();
			Turma aSerApagado = entityManager.find(Turma.class,t.getIdTurma());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

    }
    
}
