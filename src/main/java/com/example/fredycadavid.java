package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/fredy")
public class fredycadavid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Me llamo Fredy Cadavid Franco</h1>");
        out.println("<p>Estoy en septimo semestre de ingenieria de sistemas</p>");
        out.println("<p>Estudio en la universidad EAFIT</p>");
        out.println("</body></html>");
    }
}