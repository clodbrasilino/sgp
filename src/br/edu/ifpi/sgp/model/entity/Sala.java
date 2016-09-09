/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model.entity;

/**
 *
 * @author Agustin
 */
public class Sala {
    private long idSala;
    private int numero;

    public Sala() {
    }

    public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.idSala ^ (this.idSala >>> 32));
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
        final Sala other = (Sala) obj;
        if (this.idSala != other.idSala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sala{" + "idSala=" + idSala + ", numero=" + numero + '}';
    }
    
    
}
