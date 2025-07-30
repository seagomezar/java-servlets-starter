package com.example;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sofia-acosta-pareja")
public class SofiaAcostaPareja extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        try {
            // Forward the request to index.jsp
            req.getRequestDispatcher("/sofia1.jsp").forward(req, resp);
        } catch (Exception e) {
            // Handle any errors that might occur during forwarding
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.setContentType("text/html");
            resp.getWriter().println("<html><body>");
            resp.getWriter().println("<h1>Error loading page</h1>");
            resp.getWriter().println("<p>Unable to load sofia1.jsp</p>");
            resp.getWriter().println("</body></html>");
        }
    }
}