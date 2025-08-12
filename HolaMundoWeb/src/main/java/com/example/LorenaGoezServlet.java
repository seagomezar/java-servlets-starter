package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LorenaGoezServlet")
public class LorenaGoezServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html><html><head><meta charset='utf-8'><title>Mi página 1</title></head><body>");
            out.println("<h1>Hola, me llamo Lorena Goez</h1>");
            out.println("<p>Soy estudiante de Sistemas, y estoy en el semestre 8.</p>");
            out.println("<p>Tuve que lidiar con muchos bugs en este tutorial y casi muero en el intento.</p>");
            out.println("<p>Pero lo logré :) .</p>");
            out.println("</body></html>");
        }
    }
}
