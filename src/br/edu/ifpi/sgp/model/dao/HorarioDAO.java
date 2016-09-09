/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.dao;

import br.edu.ifpi.sgp.model.entity.DiaEHora;
import br.edu.ifpi.sgp.model.entity.Horario;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface HorarioDAO {
	
	public void adicionarHorario(Horario h);
    
        public Horario selecionarHorario(DiaEHora d);
        
	public List<Horario> listarHorario();
        
        public void AlterarHorario(Horario h);
	
	public void removerHorario(Horario h);
    
}
