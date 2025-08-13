package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/JuanManuelMontoya2")
public class JuanManuelMontoya2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Estoy en séptimo semestre, me encanta el fútbol. Soy hincha a morir de Atlético Nacional y cuando juego lo hago de 10, dicen que juego como Gio Moreno</h1>");
        out.println("</body></html>");
    }
}