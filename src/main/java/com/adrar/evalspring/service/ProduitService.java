package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.ProductNotFoundException;
import com.adrar.evalspring.exception.ProduitExistsExecption;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    // Ajouter un produit
    public Produit addProduct(Produit produit) {
        if (produitRepository.existsByName(produit.getNom())) {
            throw new ProduitExistsExecption("La boisson avec le name suivant : " + produit.getNom() + " existe déjà");
        }
        return produitRepository.save(produit);
    }
    // Récupérer la liste de tous les produits
    public List<Produit> getAllDrink()
    {
        if (produitRepository.count() == 0) {
            throw new ProductNotFoundException("La liste des boissons est vide");
        }
        return (List<Produit>) produitRepository.findAll();
    }

    // Récupérer un produit par ID
    public Optional<Produit> getDrinkById(Integer id) {
        return Optional
                .of(produitRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ProductNotFoundException("La boisson avec id :" + id + " n'existe pas")
                        )
                );

    }
}

