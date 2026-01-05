package com.adrar.evalspring.repository;

import com.adrar.evalspring.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
    public boolean existsByLibele(String libele);
}

