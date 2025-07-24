package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple test to verify JUnit 5 is working correctly.
 */
public class HolaMundoServletTest {

    @Test
    @DisplayName("Test servlet class can be instantiated")
    public void testServletInstantiation() {
        HolaMundoServlet servlet = new HolaMundoServlet();
        assertNotNull(servlet, "Servlet should be instantiated successfully");
    }

    @Test
    @DisplayName("Test basic functionality")
    public void testBasicFunctionality() {
        assertTrue(true, "Basic test should pass");
        assertEquals(2, 1 + 1, "Math should work correctly");
    }
}