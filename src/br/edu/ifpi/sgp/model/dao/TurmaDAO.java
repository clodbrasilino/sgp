/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Turma;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface TurmaDAO {
	
	public void adicionarTurma(Turma t);
    
        public Turma selecionarTurma(Long idTurma);
        
	public List<Turma> listarTurma();
        
        public void AlterarTurma(Turma t);
	
	public void removerTurma(Turma t);
    
}
