package com.example;

import com.exceptions.ValidationException;


public class App 
{
    public static void main( String[] args ) throws ValidationException
    {
        System.out.println( "Welcome to the Input Validation Using Annotations program!" );

        User u1 = new User("Himanshu","Him@1234",89);

        try{
            ValidationProcessor.validate(u1);
            System.out.println("User Validated");
        }
        catch(ValidationException e){
            System.out.println("Validation for this user failed with the following message:- "+e.getMessage());
        }

        User u2 = new User("","Him@1234",89);

        try{
            ValidationProcessor.validate(u2);
            System.out.println("User Validated");
        }
        catch(ValidationException e){
            System.out.println("Validation for this user failed with the following message:- "+e.getMessage());
        }

        User u3 = new User("Himanshu","Him@1234",-89);

        try{
            ValidationProcessor.validate(u3);
            System.out.println("User Validated");
        }
        catch(ValidationException e){
            System.out.println("Validation for this user failed with the following message:- "+e.getMessage());
        }
    }
    }

    

