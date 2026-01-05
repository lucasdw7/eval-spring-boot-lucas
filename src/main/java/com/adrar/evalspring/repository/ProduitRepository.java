package com.adrar.evalspring.repository;

import com.adrar.evalspring.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository <Produit, Integer> {
    public boolean existsByName(String nom);

}
