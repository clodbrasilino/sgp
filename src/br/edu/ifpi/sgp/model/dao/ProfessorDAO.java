/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Professor;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface ProfessorDAO {
	
	public void adicionarProfessor(Professor p);
    
        public Professor selecionarProfessor(long idProfessor);
        
	public List<Professor> listarProfessor();
        
        public void AlterarProfessor(Professor p);
	
	public void removerProfessor(Professor p);
    
}
