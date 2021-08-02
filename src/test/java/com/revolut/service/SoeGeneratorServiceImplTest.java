package com.revolut.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoeGeneratorServiceImplTest {

    @Test
    public void testGenerateSoe_ShouldGenerateFourAlphaNumericChars(){
        SoeGeneratorServiceImpl soeGeneratorService = new SoeGeneratorServiceImpl();
        assertTrue(soeGeneratorService.generateSoe().get().length()==4);
    }

}