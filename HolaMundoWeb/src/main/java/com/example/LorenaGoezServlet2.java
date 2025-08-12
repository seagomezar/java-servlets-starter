package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LorenaGoezServlet2")
public class LorenaGoezServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html><html><head><meta charset='utf-8'><title>Mi página 2</title></head><body>");
            out.println("<h1>Esta es la página 2</h1>");
            out.println("<p>Uno de mis hobbies es tocar el bajo eléctrico.</p>");
            out.println("<p>Me gusta mucho el cine y la literatura también..</p>");
            out.println("</body></html>");
        }
    }
}
