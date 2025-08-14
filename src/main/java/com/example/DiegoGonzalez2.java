package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Diego-Gonzalez-2")
public class DiegoGonzalez2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1 style=\"color:green\">Sobre mí</h1>");
        out.println("<p>Mi nombre es Diego Gonzalez y soy estudiante de Ingeniería de Sistemas en quinto semestre.</p>");
        out.println("<p>Disfruto mucho practicar fútbol, jugar ajedrez, montar bicicleta, leer y aprender matemáticas.</p>");
        out.println("<p>Mi meta es combinar mis habilidades técnicas con mis pasiones para crear soluciones innovadoras.</p>");
        out.println("</body></html>");
    }
}