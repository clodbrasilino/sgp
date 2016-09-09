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
public enum DiaEHora {
    SEG7H10("Segunda-feira, das 7h10 às 7h55"),
    SEG7H55("Segunda-feira, das 7H55 às 8h50"),
    SEG8H50("Segunda-feira, das 8h50 às 7h55"),
    SEG9H35("Segunda-feira, das 7h10 às 7h55"),
    SEG10H30("Segunda-feira, das 7h10 às 7h55"),
    SEG11H15("Segunda-feira, das 7h10 às 7h55"),
    SEG13H00("Segunda-feira, das 7h10 às 7h55"),
    SEG14H00("Segunda-feira, das 7h10 às 7h55"),
    SEG15H00("Segunda-feira, das 7h10 às 7h55"),
    SEG16H00("Segunda-feira, das 7h10 às 7h55"),
    SEG17H00("Segunda-feira, das 7h10 às 7h55"),
    SEG18H00("Segunda-feira, das 7h10 às 7h55"),
    SEG19H00("Segunda-feira, das 7h10 às 7h55"),
    SEG20H00("Segunda-feira, das 7h10 às 7h55"),
    SEG21H00("Segunda-feira, das 7h10 às 7h55");
    
    private String nomeBonito;
    
    private DiaEHora(String nomeBonito){
        this.nomeBonito = nomeBonito;
    }
    
    public String getNomeBonito(){
        return this.nomeBonito;
    }
}
