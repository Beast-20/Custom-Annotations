package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.exceptions.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void happy_test()
    {
        User u1 = new User("Himanshu", "Him123", 22);
        try{
            ValidationProcessor.validate(u1);
            assertTrue( true );
       }
       catch(ValidationException e){
        System.out.println("Here exception was not expected "+e.getMessage());
       }
    }

    @Test
    public void sad_test()
    {
        User u2 = new User("", "Him123", 22);
        try{
            ValidationProcessor.validate(u2);
            fail("Here exception was expected");
       }
       catch(ValidationException e){
        assertTrue(true);
       }
    }
       
}

