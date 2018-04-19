/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.PiezasCtrl;
import com.sv.udb.modelos.Piezas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edwin
 */
@WebServlet(name = "PiezasServ", urlPatterns = {"/PiezasServ"})
public class PiezasServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        boolean resp = false;
        if(!esValido){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else{
            String CRUD = request.getParameter("btnPie");
            if(CRUD.equals("Guardar")){
                if(new PiezasCtrl().guardar(request.getParameter("nomb"), request.getParameter("tipo"), request.getParameter("marca"))){
                    mens = "Datos guardados";
                    resp = true;
                    
                }
                else{
                    mens = "Error al guardar datos";
                }
                
            }
            else if(CRUD.equals("Consultar")){
                int codi = Integer.parseInt(request.getParameter("codiPiezRadi") == null ? "-1" :
                        request.getParameter("codiPiezRadi"));
                Piezas obj = new PiezasCtrl().cons(codi);
                if(obj != null){
                    request.setAttribute("codi", obj.getCodiPiez());
                    request.setAttribute("nomb", obj.getNomPiez());
                    request.setAttribute("marca", obj.getMarcPiez());
                    request.setAttribute("tipo", obj.getTipoPiez());
                    
                    request.setAttribute("estaModi", true);
                }
                else{
                    mens = "Error al consultar";
                }
            }
            request.setAttribute("menAler", mens);
            request.setAttribute("resp", resp);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
