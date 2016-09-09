/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.entity;

import java.util.List;

/**
 *
 * @author Agustin
 */
public class Coordenacao {
    private long idCoordenacao;
    private String Nome;
    private Professor Coordenador;
    private List<Professor> professores;
    private List<Turma> turmas;

    public Coordenacao(){}
    
    
    public long getIdCoordenacao() {
        return idCoordenacao;
    }

    public void setIdCoordenacao(long idCoordenacao) {
        this.idCoordenacao = idCoordenacao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Professor getCoordenador() {
        return Coordenador;
    }

    public void setCoordenador(Professor Coordenador) {
        this.Coordenador = Coordenador;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.idCoordenacao ^ (this.idCoordenacao >>> 32));
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
        final Coordenacao other = (Coordenacao) obj;
        if (this.idCoordenacao != other.idCoordenacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordenacao{" + "idCoordenacao=" + idCoordenacao + ", Nome=" + Nome + ", Coordenador=" + Coordenador + ", professores=" + professores + ", turmas=" + turmas + '}';
    }
    
    
    
    
}
