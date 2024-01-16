package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AppTest {

    @Test
    public void testMain() {
        String[] args = {}; // No arguments are passed to the main method
        String result = App.main(args);
        assertEquals("Hello World!!!!", result, "The main method should return 'Hello World!!!!'");
    }
}