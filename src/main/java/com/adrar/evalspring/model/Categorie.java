package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Le libellé de la catégorie ne peut pas être nul")
    @NotBlank(message = "Le libellé de la catégorie ne peut pas être vide")
    @Size(min = 3, message = "Le nom du produit doit contenir au moins 3 caractères")
    @Column(nullable = false)
    private String libele;
}
