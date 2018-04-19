/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

/**
 *
 * @author edwin
 */
public class Piezas {
    private int codiPiez;
    private String nomPiez;
    private String tipoPiez;
    private String marcPiez;

    public Piezas() {
    }

    public Piezas(int codiPiez, String nomPiez, String tipoPiez, String marcPiez) {
        this.codiPiez = codiPiez;
        this.nomPiez = nomPiez;
        this.tipoPiez = tipoPiez;
        this.marcPiez = marcPiez;
    }

    public int getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(int codiPiez) {
        this.codiPiez = codiPiez;
    }

    public String getNomPiez() {
        return nomPiez;
    }

    public void setNomPiez(String nomPiez) {
        this.nomPiez = nomPiez;
    }

    public String getTipoPiez() {
        return tipoPiez;
    }

    public void setTipoPiez(String tipoPiez) {
        this.tipoPiez = tipoPiez;
    }

    public String getMarcPiez() {
        return marcPiez;
    }

    public void setMarcPiez(String marcPiez) {
        this.marcPiez = marcPiez;
    }

    @Override
    public String toString() {
        return this.nomPiez;
    }
    
    
}
