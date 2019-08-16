package com.terrain.utilitaire;

/**
 * @author 1895648
 */
public class ValidationException  extends Exception{ 
    public ValidationException(String message, Object variable) {
        super(message +" ("+ variable.toString()+")");
    }   
}