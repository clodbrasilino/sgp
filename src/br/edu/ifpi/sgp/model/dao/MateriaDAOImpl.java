/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Materia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Agustin
 */
public class MateriaDAOImpl implements MateriaDAO{
	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();


    @Override
    public void adicionarMateria(Materia m) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(m);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public Materia selecionarMateria(long m) {

        return entityManager.createNamedQuery("select m from Mateira m where idMateria = :idMateria", Materia.class)
                .setParameter("idMateria", m)
                .getSingleResult();
        
    }

    @Override
    public List<Materia> listarMateria() {
        
        return (List<Materia>) entityManager.createNamedQuery("select m from Materia m = :idMateira");
        
    }

    @Override
    public void AlterarMateria(Materia m) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(m);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public void removerMateria(Materia m) {
		try{
			entityManager.getTransaction().begin();
			Materia aSerApagado = entityManager.find(Materia.class,m.getIdMateria());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

    }
    
    
}
