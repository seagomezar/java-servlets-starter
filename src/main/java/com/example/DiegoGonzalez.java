package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Diego-Gonzalez")
public class DiegoGonzalez extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1 style=\"color:blue\">Hola, mi nombre es Diego Gonzalez</h1>");
        out.println("<p>Estudiante de Ingeniería de Sistemas, actualmente en quinto semestre.</p>");
        out.println("<p>Me gustan el fútbol, el ajedrez, montar bicicleta, leer y las matemáticas.</p>");
        out.println("</body></html>");
    }
}