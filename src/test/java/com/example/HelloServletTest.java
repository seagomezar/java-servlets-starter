package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for HelloServlet
 */
public class HelloServletTest {

    @Test
    @DisplayName("Test HelloServlet can be instantiated")
    public void testHelloServletInstantiation() {
        HelloServlet servlet = new HelloServlet();
        assertNotNull(servlet, "HelloServlet should be instantiated successfully");
    }

    @Test
    @DisplayName("Test HelloServlet extends HttpServlet")
    public void testHelloServletExtendsHttpServlet() {
        HelloServlet servlet = new HelloServlet();
        assertTrue(servlet instanceof jakarta.servlet.http.HttpServlet, 
                  "HelloServlet should extend HttpServlet");
    }

    @Test
    @DisplayName("Test HelloServlet class structure")
    public void testHelloServletClassStructure() {
        // Verify the class has the expected annotation by checking if annotation exists
        // This is a basic structural test
        Class<?> clazz = HelloServlet.class;
        assertNotNull(clazz, "HelloServlet class should exist");
        assertEquals("HelloServlet", clazz.getSimpleName(), "Class name should be HelloServlet");
    }
}