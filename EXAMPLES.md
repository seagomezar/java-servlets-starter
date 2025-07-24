# 🧪 Hands-On Examples and Exercises

This file contains practical examples and exercises to help you learn Java servlets step by step.

## Example 1: Basic Servlet Response

**Goal**: Understand how a servlet generates HTML responses

**Current Code** (`HolaMundoServlet.java`):
```java
out.println("<html><body>");
out.println("<h1>Hola Mundo desde un Servlet!</h1>");
out.println("</body></html>");
```

**Exercise**: Modify the servlet to include:
- Current date and time
- A personalized greeting
- Some basic CSS styling

**Solution**:
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    
    // Get current date
    java.util.Date now = new java.util.Date();
    
    out.println("<html>");
    out.println("<head>");
    out.println("<style>");
    out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; }");
    out.println("h1 { color: #333; text-align: center; }");
    out.println(".container { max-width: 600px; margin: 0 auto; padding: 20px; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>¡Hola Mundo desde un Servlet!</h1>");
    out.println("<p>Current time: " + now + "</p>");
    out.println("<p>Welcome to Java Servlet development!</p>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
}
```

## Example 2: Handling Request Parameters

**Goal**: Learn to read and process user input

**Exercise**: Create a servlet that greets users by name

**Create** `GreetingServlet.java`:
```java
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        // Get parameter from URL (e.g., /greeting?name=John)
        String name = req.getParameter("name");
        
        if (name == null || name.trim().isEmpty()) {
            name = "Anonymous";
        }
        
        out.println("<html><body>");
        out.println("<h1>Hello, " + name + "!</h1>");
        out.println("<p>Try visiting: <code>/greeting?name=YourName</code></p>");
        out.println("</body></html>");
    }
}
```

**Test URLs**:
- `http://localhost:8080/HolaMundoWeb/greeting` → "Hello, Anonymous!"
- `http://localhost:8080/HolaMundoWeb/greeting?name=Maria` → "Hello, Maria!"

## Example 3: Form Processing

**Goal**: Handle HTML forms and POST requests

**Create a form** in `src/main/webapp/form.html`:
```html
<!DOCTYPE html>
<html>
<head>
    <title>Contact Form</title>
</head>
<body>
    <h2>Contact Us</h2>
    <form action="contact" method="post">
        <p>
            <label>Name:</label><br>
            <input type="text" name="name" required>
        </p>
        <p>
            <label>Email:</label><br>
            <input type="email" name="email" required>
        </p>
        <p>
            <label>Message:</label><br>
            <textarea name="message" rows="4" cols="50" required></textarea>
        </p>
        <p>
            <input type="submit" value="Send Message">
        </p>
    </form>
</body>
</html>
```

**Create** `ContactServlet.java`:
```java
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        // Get form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");
        
        // In a real application, you would save this to a database
        // For now, we'll just display it
        
        out.println("<html><body>");
        out.println("<h2>Thank you for your message!</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Message:</strong> " + message + "</p>");
        out.println("<p><a href='form.html'>Send another message</a></p>");
        out.println("</body></html>");
    }
}
```

## Example 4: Session Management

**Goal**: Understand how to maintain state between requests

**Create** `CounterServlet.java`:
```java
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        // Get or create session
        HttpSession session = req.getSession();
        
        // Get current count from session (default to 0)
        Integer count = (Integer) session.getAttribute("visitCount");
        if (count == null) {
            count = 0;
        }
        
        // Increment and save back to session
        count++;
        session.setAttribute("visitCount", count);
        
        out.println("<html><body>");
        out.println("<h1>Visit Counter</h1>");
        out.println("<p>You have visited this page " + count + " times.</p>");
        out.println("<p><a href='counter'>Refresh</a> | ");
        out.println("<a href='counter?reset=true'>Reset Counter</a></p>");
        out.println("</body></html>");
        
        // Handle reset
        if ("true".equals(req.getParameter("reset"))) {
            session.setAttribute("visitCount", 0);
        }
    }
}
```

## Progressive Exercises

### Beginner Level
1. **Modify HolaMundoServlet**: Add current date/time display
2. **Create a Calculator Servlet**: Accept two numbers via URL parameters and show their sum
3. **Build a Simple Menu**: Create a servlet that shows links to other servlets

### Intermediate Level
1. **Create a Guest Book**: Allow users to leave messages and display all messages
2. **Build a Simple Login**: Use sessions to track logged-in users
3. **File Upload Handler**: Accept file uploads and display file information

### Advanced Level
1. **RESTful API**: Create servlets that return JSON instead of HTML
2. **Database Integration**: Connect to a database to store and retrieve data
3. **Filter Implementation**: Create servlet filters for logging or authentication

## Debugging Tips

### Common Issues and Solutions

**Issue**: "404 Not Found" when accessing servlet
**Solution**: Check the `@WebServlet` annotation path and ensure it matches your URL

**Issue**: "500 Internal Server Error"
**Solution**: Check Tomcat logs for stack traces, usually in `logs/catalina.out`

**Issue**: Parameters return null
**Solution**: Verify parameter names match between HTML form and servlet code

**Issue**: Session data lost
**Solution**: Ensure cookies are enabled in your browser

### Testing Your Servlets

1. **Browser Testing**: Use browser developer tools to inspect requests/responses
2. **Postman/curl**: Test different HTTP methods and parameters
3. **Unit Testing**: Write JUnit tests for servlet logic (see existing test examples)

## Next Steps

After completing these examples:

1. **Explore JSP**: Learn JavaServer Pages for better HTML template management
2. **Add a Database**: Integrate with MySQL or PostgreSQL
3. **Learn Frameworks**: Move to Spring Boot for more advanced development
4. **Deploy to Cloud**: Try deploying to AWS, Google Cloud, or Heroku

Happy coding! 🚀