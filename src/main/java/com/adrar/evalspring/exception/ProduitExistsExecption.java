package com.adrar.evalspring.exception;

public class ProduitExistsExecption extends RuntimeException {
    public ProduitExistsExecption(String message) {
        super(message);
    }
}