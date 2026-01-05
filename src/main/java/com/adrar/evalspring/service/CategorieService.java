package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.CategorieExistsExecption;
import com.adrar.evalspring.exception.CategorieNotFoundException;
import com.adrar.evalspring.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import com.adrar.evalspring.model.Categorie;

import java.util.List;
import java.util.Optional;


@Service
public class CategorieService {

    private CategorieRepository categorieRepository;

    // Ajouter une categorie
    public Categorie addCategorie(Categorie categorie) {
        if (categorieRepository.existsByLibele(categorie.getLibele())) {
            throw new CategorieExistsExecption("La categorie " + categorie.getLibele() + " existe déjà");
        }
        return categorieRepository.save(categorie);
    }

    // Récupérer la liste de toutes les categories
    public List<Categorie> getAllCategorie()
    {
        if (categorieRepository.count() == 0) {
            throw new CategorieNotFoundException("La liste des catégories est vide");
        }
        return (List<Categorie>) categorieRepository.findAll();
    }

    // récupérer une categorie par ID
    public Optional<Categorie> getCategorieById(Integer id) {
        return Optional
                .of(categorieRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new CategorieNotFoundException("La catégorie avec id :" + id + " n'existe pas")
                        )
                );

    }

}
