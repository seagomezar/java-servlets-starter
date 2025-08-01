package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Alejandra-Ortiz-2")
public class AlejandraOrtiz2 extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>Mi Perro Romeo</title></head>");
        out.println("<body>");
        out.println("<p> También tengo un perrito que se llama Romeo y está bien tierno <3.</p>");
        out.println("<img src=\"imagenes/ROMEO.jpg\" alt=\"Romeo\" style=\"max-width:300px; display:block; margin-top:10px;\">");
        out.println("</body>");
        out.println("</html>");
    }
}