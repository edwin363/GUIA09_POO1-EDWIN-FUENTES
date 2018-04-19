/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelos.Piezas;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin
 */
public class PiezasCtrl {
    private final Connection conn;

    public PiezasCtrl() {
        this.conn = new Conexion().getConn();
    }
    
    public boolean guardar(String nomb_piez, String tipo_piez, String marc_piez){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("insert into piezas values(NULL,?,?,?)");
            cmd.setString(1, nomb_piez);
            cmd.setString(2, tipo_piez);
            cmd.setString(3, marc_piez);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.err.println("Error al guardar proveedores: " + e.getMessage());
        }
        
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException e)
            {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public List<Piezas> tabla(){
        List<Piezas> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("select * from piezas");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new Piezas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception ex) {
             System.err.println("Error al consultar piezas: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public Piezas cons(int codi_piez){
        Piezas resp = null;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("select * from piezas where codi_piez = ?");
            cmd.setInt(1, codi_piez);
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                resp = new Piezas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public boolean modificar(String nomb_piez, String tipo_piez, String marc_pieza){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("update piezas set nomb_piez = ?, tipo_piez = ?, marc_piez = ?");
            cmd.setString(1, nomb_piez);
            cmd.setString(2, tipo_piez);
            cmd.setString(3, marc_pieza);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public boolean eliminar(int codi_piez){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("delete from piez where codi_piez = ?");
            cmd.setInt(1, codi_piez);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
}
