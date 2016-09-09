/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.Sala;
import java.util.List;


/**
 *
 * @author Agustin
 */
public interface SalaDAO {
	
	public void adicionarSala(Sala s);
    
        public Sala selecionarSala(Long idSala);
        
	public List<Sala> listarSala();
        
        public void AlterarSala(Sala s);
	
	public void removerSala(Sala s);
    
}
