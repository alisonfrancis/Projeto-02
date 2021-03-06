/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.ads.poo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "JurosComposto", urlPatterns = {"/juroscomposto.html"})
public class JurosComposto extends HttpServlet {

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
            
    /* Style Test */
             out.println("<style>.p{font-family: 'Raleway', sans-serif;}</style>");
          
    /* Fim Style Test */  
            
            out.println("<head>");
            out.println("<title>Juros Composto</title>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            /* ---- CSS ------ */
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
    /* ----Fim CSS ------- */
                    
    /* ---- Google Fonts ----*/    
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Orbitron\" rel=\"stylesheet\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Advent+Pro\" rel=\"stylesheet\"> ");
    /* ------ Fim Fonts -----*/
    
    /* ------ FAVICON -----*/ 
            out.println("<link rel=\"shortcut icon\" href=\"Imagens/favicon6.png\" />");
    /*---Fim do FAVICON --- */ 
            
            out.println("</head>");
            out.println("<body class='p'>");
            
    /*--- NAVBAR ---*/
                out.println(  /*Botoes da navbar*/"<br><ul class=\"nav nav-tabs \">\n" +
"  <li class=\"nav-item\">\n" +
"    <a class=\"nav-link active\" href=\"home.html\">Continf</a>\n" +
"  </li>\n" +
"  <li class=\"nav-item\">\n" +
"    <a class=\"nav-link\" href=\"home.html\">Home</a>\n" +
"  </li>\n" +
"  <li class=\"nav-item\">\n" +
"    <a class=\"nav-link\" href=\"jurossimples.html\">Juros Simples</a>\n" +
"  </li>\n" +
"  <li class=\"nav-item\">\n" +
"    <a class=\"nav-link\" href=\"juroscomposto.html\">Juros Composto</a>\n" +
"  </li>\n" +
"</ul>" /* fim dos botoes*/
                       );
   /*--- Fim NAVBAR ---*/
   
/* INICIO DO CONTEUDO */

                 out.println("<div class=\"card\">\n" +
                         "  <h2 class=\"card-header\">Juros Composto</h2>\n" +
                         "  <div class=\"card-body\">");
            
             out.println("<center>");
            out.println("<form>");
            out.println("<table>");
            out.println("<P> Digite os valores no campo abaixo:</p>");
            out.println("<tr><td><input class=\"form-control\" type=\"text\" name=\"c\" placeholder=\"Volor Capital\"></td></tr>");
           
            out.println("<tr><td><input class=\"form-control\" type=\"text\" name=\"i\" placeholder=\"Taxa juros\"></td></tr>");
           
            out.println("<tr><td><input class=\"form-control\" type=\"text\" name=\"n\" placeholder=\"Meses\"></td></tr>");
            out.println("</table>");
            out.println("<br><input class=\"bttbody btn btn-secondary\" type=\"submit\" name=\"enviar\" value=\"Calcular\"></td></tr>");
              
            out.println("</form>");
            out.print("</center>");
             out.println("  </div>\n" +"</div>");
            out.println("<hr>");
            
            try {
                 /* Variavel para jurus composto */
                Double c,i,Moc;
                int n;
                
                /* converte tipo texto para numerico */
                
                c = Double.parseDouble(request.getParameter("c"));
                  i = Double.parseDouble(request.getParameter("i"));
                     n = Integer.parseInt(request.getParameter("n"));
                     
                 /*Colocando duas casa */    
               DecimalFormat df = new DecimalFormat("0.##");
             
                
               out.println("<center><h4>");
                    out.println("<div><table class=\"table table-hover\" border='1'>");
                    out.println("<tr class=\"table-active\"><th>Mês</th><th>Montante acumulado</th></tr>");
                   
                    for (int cont = 1; cont <= n; cont++){
                        Moc = c * Math.pow((1 + (i / 100)), cont);
                        /* convertendo o valor para duas casa*/
                        String Mof = df.format(Moc);
                        out.println("<tr><th scope=\"row\">" + cont + "</th><td>" +Mof+ "</td></tr>");
                    }
                    out.println("</table></div>");
              out.println("</center></h4>");
            }
            
            catch(Exception e){
                
                  out.println("<center>");             
                    out.println("ENTRA COM VALOR VALIDO ");
                out.println("</center>");
            }
            
            /* Link da pagina Home */
                     
            /* Fim do link da pagina Home */
/* FIM DO CONTEUDO */
            
     /*---- Footer-----------*/
        out.println("<hr><br>\n"+
       "<footer class=\"container footer-css\">\n"+
         "   <p class=\"float-right\"><a href=\"#\">Back to top</a></p>\n"+
          "      <p>&copy; 2018 Fatec, Pg. &middot; <a href=\"https://github.com/alisonfrancis/Projeto-02\">Site do Projeto</a></p>\n"+
        "</footer>");
    /* --- Fim do Footer------*/
    
    /* ----- JS ------*/
            out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
    /* -----Fim do JS ----*/
    
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
