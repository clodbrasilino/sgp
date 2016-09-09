 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Agustin
 */
public class ProfessorDAOImpl implements ProfessorDAO{
	EntityManager entityManager = Persistence.createEntityManagerFactory("sgp").createEntityManager();


    @Override
    public void adicionarProfessor(Professor p) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public Professor selecionarProfessor(long idProf) {

        return entityManager.createNamedQuery("select idProf from Professor idProf where idProfessor = :idProfessor", Professor.class)
                .setParameter("idProfessor", idProf)
                .getSingleResult();
        
    }

    @Override
    public List<Professor> listarProfessor() {
        
        return (List<Professor>) entityManager.createNamedQuery("select p from Professor p = :idProfessor");
        
    }

    @Override
    public void AlterarProfessor(Professor p) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(p);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    @Override
    public void removerProfessor(Professor p) {
		try{
			entityManager.getTransaction().begin();
			Professor aSerApagado = entityManager.find(Professor.class,p.getIdProfessor());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

    }
    
}
