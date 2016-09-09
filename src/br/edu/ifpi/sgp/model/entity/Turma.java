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
public class Turma {
    private long idTurma;
    private Coordenacao coordenacao;
    private String Turno;
    private String anoLetivo;
    private List<Materia> materias;

    public Turma() {
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    public Coordenacao getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(Coordenacao coordenacao) {
        this.coordenacao = coordenacao;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (int) (this.idTurma ^ (this.idTurma >>> 32));
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
        final Turma other = (Turma) obj;
        if (this.idTurma != other.idTurma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "idTurma=" + idTurma + ", coordenacao=" + coordenacao + ", Turno=" + Turno + ", anoLetivo=" + anoLetivo + '}';
    }
    
    
}
