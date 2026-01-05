package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    private CategorieService categorieService;

    // ➕ Ajouter une categorie
    @PostMapping("/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie createCategorie(@RequestBody Categorie categorie)
    {
        return categorieService.addCategorie(categorie);
    }

    // 📋 Récupérer tous les produits (avec catégorie)
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Categorie> getAllCategorie()
    {
        return  categorieService.getAllCategorie();
    }

    // 🔍 Récupérer un produit par ID (avec catégorie)
    @GetMapping("/categorie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Categorie> getCategorie(@PathVariable Integer id)
    {
        return categorieService.getCategorieById(id);
    }
}

