package com.poe.poe2220718.poe20220718.tpwordle;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/wordle")
public class WordleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
        
        Partie partie = (Partie)request.getSession().getAttribute("partie");
        if(partie==null) {
            DictionaireDeMots dictionnaire = new DictionaireDeMotsSansBaseDeDonnees();
            char[] motADeviner = dictionnaire.obtenirUnMotAleatoirement();
            partie = new Partie(motADeviner);
            request.getSession().setAttribute("partie",partie);
        }
      
        //request.setAttribute("motADeviner", new String(partie.getMotADeviner()));
        request.setAttribute("motADeviner", String.valueOf(partie.getMotADeviner()));
        request.getRequestDispatcher("WEB-INF/wordle.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException
     {
         String proposition = request.getParameter("proposition");
         
         Partie partie = (Partie)request.getSession().getAttribute("partie");
         partie.jouer(proposition.toCharArray());
         
         if(partie.nombreTentativesMaxAtteint() && !partie.motDevine()){
             request.getSession().setAttribute("partie", null);
             request.getRequestDispatcher("WEB-INF/perdu.jsp").forward(request, response);
         } else {
             if(partie.motDevine()){
                 request.getSession().setAttribute("partie", null);
                 request.getRequestDispatcher("WEB-INF/gagne.jsp").forward(request, response);
             }
             else {
                  doGet(request, response);
             }
         }
    }
}
