/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Chamado;
import br.edu.ifrs.modelo.dao.ChamadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suelen
 */
@WebServlet(name = "ChamadoControl", urlPatterns = {"/ChamadoControl"})
public class ChamadoControl extends HttpServlet {

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
        try {
            String op = request.getParameter("op");
            
            if (op.equals("LISTA") || op.equals("CONSULTA") || op.equals("CONSATUALIZAR")) consultar(request, response, op);
            else if(op.equals("INSERIR")) inserir(request, response);
            else if(op.equals("EXCLUIR")) excluir(request, response);
            else if(op.equals("ATUALIZAR")) atualizar(request, response);
            else if(op.equals("NOVO")) abrir(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void abrir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        
    }
    
    protected void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Chamado ch = new Chamado();
        
        try {
            
            ch.setNomeSolicitante(request.getParameter("nome"));  
            ch.setPerfilSolicitante(request.getParameter("perfil"));
            ch.setEmailSolicitante(request.getParameter("email"));
            ch.setTelefoneSolicitante(request.getParameter("telefone"));
            ch.setDescricaoSolicitacao(request.getParameter("descricao"));
            ch.setSituacao("aberto");
            ch.setDataAbertura(Calendar.getInstance());
            ch.setAnexo(null);
         
            
            ChamadoDAO.adicionar(ch);

            RequestDispatcher r = request.getRequestDispatcher( "sucesso.jsp" );
            r.forward( request, response );
            
//            consultar(request, response, "LISTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response, String op)
            throws ServletException, IOException {

        
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
