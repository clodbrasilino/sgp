/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Materia;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface MateriaDAO {
	
	public void adicionarMateria(Materia m);
    
        public Materia selecionarMateria(long idMateria);
        
	public List<Materia> listarMateria();
        
        public void AlterarMateria(Materia m);
	
	public void removerMateria(Materia m);
    
}
