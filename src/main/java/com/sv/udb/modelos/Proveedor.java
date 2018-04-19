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
public class Proveedor {
    private int codiProve;
    private String nombProve;
    private String direProve;
    private int teleProve;

    public Proveedor() {
    }

    public Proveedor(int codiProve, String nombProve, String direProve, int teleProve) {
        this.codiProve = codiProve;
        this.nombProve = nombProve;
        this.direProve = direProve;
        this.teleProve = teleProve;
    }

    public int getCodiProve() {
        return codiProve;
    }

    public void setCodiProve(int codiProve) {
        this.codiProve = codiProve;
    }

    public String getNombProve() {
        return nombProve;
    }

    public void setNombProve(String nombProve) {
        this.nombProve = nombProve;
    }

    public String getDireProve() {
        return direProve;
    }

    public void setDireProve(String direProve) {
        this.direProve = direProve;
    }

    public int getTeleProve() {
        return teleProve;
    }

    public void setTeleProve(int teleProve) {
        this.teleProve = teleProve;
    }

    @Override
    public String toString() {
        return this.nombProve;
    }
    
    
}
