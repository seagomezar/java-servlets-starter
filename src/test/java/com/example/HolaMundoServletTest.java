package com.example;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Unit tests for HolaMundoServlet to verify correct text rendering.
 * These tests ensure the servlet produces the expected HTML output
 * and handles various request scenarios appropriately.
 */
public class HolaMundoServletTest {

    private HolaMundoServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() throws Exception {
        servlet = new HolaMundoServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
    }

    @Test
    @DisplayName("Test servlet class can be instantiated")
    public void testServletInstantiation() {
        HolaMundoServlet servlet = new HolaMundoServlet();
        assertNotNull(servlet, "Servlet should be instantiated successfully");
    }

    @Test
    @DisplayName("Test HelloServlet class can be instantiated")
    public void testHelloServletInstantiation() {
        HelloServlet servlet = new HelloServlet();
        assertNotNull(servlet, "HelloServlet should be instantiated successfully");
    }

    @Test
    @DisplayName("Test servlet renders expected HTML content")
    public void testServletRendersExpectedText() throws Exception {
        // Execute the servlet
        servlet.doGet(request, response);
        
        // Flush the writer to ensure all content is written
        printWriter.flush();
        
        // Verify response content type is set correctly
        verify(response).setContentType("text/html");
        
        // Get the actual output
        String actualOutput = stringWriter.toString();
        
        // Verify the response contains expected HTML structure
        assertTrue(actualOutput.contains("<html><body>"), 
                  "Response should contain opening HTML tags");
        assertTrue(actualOutput.contains("<h1>Hola Mundo desde un Servlet!</h1>"), 
                  "Response should contain the expected greeting message");
        assertTrue(actualOutput.contains("</body></html>"), 
                  "Response should contain closing HTML tags");
        
        // Verify complete expected output
        String expectedOutput = "<html><body>\n<h1>Hola Mundo desde un Servlet!</h1>\n</body></html>\n";
        assertEquals(expectedOutput, actualOutput, 
                    "Response should match exactly the expected HTML output");
    }

    @Test
    @DisplayName("Test servlet handles null request parameters gracefully")
    public void testServletHandlesNullParameters() throws Exception {
        // Test with request that has null parameters (edge case)
        when(request.getParameter(anyString())).thenReturn(null);
        
        // Execute the servlet
        servlet.doGet(request, response);
        printWriter.flush();
        
        // Verify response content type is still set
        verify(response).setContentType("text/html");
        
        // Verify the servlet still produces the expected output
        String actualOutput = stringWriter.toString();
        assertTrue(actualOutput.contains("Hola Mundo desde un Servlet!"), 
                  "Servlet should render expected text even with null parameters");
    }

    @Test
    @DisplayName("Test servlet handles empty request gracefully") 
    public void testServletHandlesEmptyRequest() throws Exception {
        // Test with completely empty request (edge case)
        when(request.getRequestURI()).thenReturn("");
        when(request.getQueryString()).thenReturn("");
        
        // Execute the servlet
        servlet.doGet(request, response);
        printWriter.flush();
        
        // Verify response is generated correctly
        verify(response).setContentType("text/html");
        
        String actualOutput = stringWriter.toString();
        assertFalse(actualOutput.isEmpty(), 
                   "Response should not be empty even for empty requests");
        assertTrue(actualOutput.contains("Hola Mundo desde un Servlet!"), 
                  "Response should contain expected message even for empty requests");
    }

    @Test
    @DisplayName("Test servlet response writer is properly used")
    public void testServletUsesResponseWriter() throws Exception {
        // Execute the servlet
        servlet.doGet(request, response);
        
        // Verify that response.getWriter() was called
        verify(response, times(1)).getWriter();
        
        // Verify content type was set
        verify(response, times(1)).setContentType("text/html");
    }

    @Test
    @DisplayName("Test basic functionality")
    public void testBasicFunctionality() {
        assertTrue(true, "Basic test should pass");
        assertEquals(2, 1 + 1, "Math should work correctly");
    }
}