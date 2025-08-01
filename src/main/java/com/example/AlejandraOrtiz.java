package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Alejandra-Ortiz")
public class AlejandraOrtiz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>Mi gata Lola</title></head>");
        out.println("<body>");
        out.println("<p>Hola soy Alejandra, tengo una gata preciosa que se llama Lola.</p>");
        out.println("<img src=\"imagenes/LOLA.jpg\" alt=\"Lola\" style=\"max-width:300px; display:block; margin-top:10px;\">");
        out.println("</body>");
        out.println("</html>");
    }
}