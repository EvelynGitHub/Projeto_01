/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.projeto01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author evelyn
 */
@WebServlet(name = "calcJurosCompostos", urlPatterns = {"/calc-juros-compostos.html"})
public class calcJurosCompostos extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calcJurosCompostos</title>");            
            out.println("<link href=\"css/c.css\" rel=\"stylesheet\" type=\"text/css\" />");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<header>");
            out.println("<div><a href='index.html'>Home</a></div> <div class='titulo'> ");
            out.println("Programação Orientada a Objetos</div>");
            out.println("</header>");

            out.println("<h1>Resultado do Calculo do Juros Composto</h1>");

            try {
                double c = Double.parseDouble(request.getParameter("capital"));
                double i = Double.parseDouble(request.getParameter("juros"));
                double t = Double.parseDouble(request.getParameter("tempo"));
                
                out.println("<h3>Valor inicial investido: R$"+c+"</h3>");
                out.println("<h3>Valor inicial dos juros: "+i+"% ao mês</h3>");
                out.println("<h3>Tempo inicial do investido: "+t+"</h3>");
                out.println("<table border=1>");                
                out.println("<tr>");
                out.println("<th>Mês</th><th>Montante</th><th>Juros Total</th>");
                out.println("</tr>");
                
                double m;
                double j;
                for(int x = 0;x <= t; x++){
                    m = (c * Math.pow((1+(i)/100), x));                   
                    j = m - c;
                    
                    out.println("<tr>");
                    out.println("<td>"+x+"</td>");//certo
                    out.printf("<td> R$ %.2f",m," </td>");
                    out.printf("<td>%.2f",j," </td>");
                    out.println("</tr>");
                    m = 0;
                    //acu += m;
                }
                
                out.println("</table>");
                
            } catch (Exception ex) {
                out.println("<h4>Desculpe, mas você precisa informar todas os valores para o calculo</h4>");
            }

            
            out.println("</body>");
            out.println("</html>");
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
