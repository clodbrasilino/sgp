/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Agustin
 */
//@Entity
public class Professor{
    //@Id
    private long idProfessor ;
    private String nome;
    private Materia materia;
    private Coordenacao coordenacao;
    private Disponibilidade disponibilidade;
    private int cargaHoraria;
    
    private List<Horario> horarios;
    private List<Materia> materias;

    public Professor() {
    }

    public long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coordenacao getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(Coordenacao coordenacao) {
        this.coordenacao = coordenacao;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.idProfessor ^ (this.idProfessor >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.idProfessor != other.idProfessor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nome = " + nome +
                "\nCoordenacao = " + coordenacao +
                "\nDisponibilidade = " + disponibilidade +
                "\nHorarios = " + horarios + 
                "\nMaterias = " + materias;
    }
    
    
    
    
}
