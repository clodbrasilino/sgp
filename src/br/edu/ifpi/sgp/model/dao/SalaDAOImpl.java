/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Sala;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Agustin
 */
public class SalaDAOImpl implements SalaDAO{
	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();


    @Override
    public void adicionarSala(Sala s) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(s);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public Sala selecionarSala(Long s) {

        return entityManager.createNamedQuery("select s from Sala s where idSala = :idSala", Sala.class)
                .setParameter("idMateria", s)
                .getSingleResult();
        
    }

    @Override
    public List<Sala> listarSala() {
        
        return (List<Sala>) entityManager.createNamedQuery("select s from Sala s = :idSala");
        
    }

    @Override
    public void AlterarSala(Sala s) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(s);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public void removerSala(Sala s) {
		try{
			entityManager.getTransaction().begin();
			Sala aSerApagado = entityManager.find(Sala.class,s.getIdSala());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

    }
    
}
