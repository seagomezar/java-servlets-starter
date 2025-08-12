package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/fredy2")
public class fredycadavid2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Esta pagina tiene mas información sobre mi</h1>");
        out.println("<p>Practico bmx (apenas estoy aprendiendo)</p>");
        out.println("<p>Me gustan los videojuegos y el anime</p>");
        out.println("</body></html>");
    }
}