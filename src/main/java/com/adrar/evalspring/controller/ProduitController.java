package com.adrar.evalspring.controller;


import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private ProduitService produitService;

    // ➕ Ajouter un produit
    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit createDrink(@RequestBody Produit produit)
    {
        return produitService.addProduct(produit);
    }

    // 📋 Récupérer tous les produits (avec catégorie)
    @GetMapping("/Produits")
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getAllProduct()
    {
        return  produitService.getAllProduct();
    }

    // 🔍 Récupérer un produit par ID (avec catégorie)
    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produit> getProduit(@PathVariable Integer id)
    {
        return produitService.getProductById(id);
    }
}
