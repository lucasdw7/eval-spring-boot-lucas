package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.CategorieExistsException;
import com.adrar.evalspring.exception.CategorieNotFoundException;
import com.adrar.evalspring.exception.ProductNotFoundException;
import com.adrar.evalspring.exception.ProduitExistsExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    // Produit non trouvé
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProduitNotFound(ProductNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Erreur création produit
    @ExceptionHandler(ProduitExistsExecption.class)
    public ResponseEntity<Map<String, String>> handleProduitCreation(ProduitExistsExecption ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Catégorie non trouvée
    @ExceptionHandler(CategorieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategorieNotFound(CategorieNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Erreur création catégorie
    @ExceptionHandler(CategorieExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategorieCreation(CategorieExistsException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
