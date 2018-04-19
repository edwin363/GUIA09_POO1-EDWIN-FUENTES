/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.sql.Date;

/**
 *
 * @author moises
 */
public class Bodega {
    private int codiBode;
    private int codiPiez;
    private int codiProve;
    private int cant;
    private Date fechCom;

    public Bodega() {
    }

    public Bodega(int codiBode, int codiPiez, int codiProve, int cant, Date fechCom) {
        this.codiBode = codiBode;
        this.codiPiez = codiPiez;
        this.codiProve = codiProve;
        this.cant = cant;
        this.fechCom = fechCom;
    }

    public int getCodiBode() {
        return codiBode;
    }

    public void setCodiBode(int codiBode) {
        this.codiBode = codiBode;
    }

    public int getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(int codiPiez) {
        this.codiPiez = codiPiez;
    }

    public int getCodiProve() {
        return codiProve;
    }

    public void setCodiProve(int codiProve) {
        this.codiProve = codiProve;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Date getFechCom() {
        return fechCom;
    }

    public void setFechCom(Date fechCom) {
        this.fechCom = fechCom;
    }
    
}
