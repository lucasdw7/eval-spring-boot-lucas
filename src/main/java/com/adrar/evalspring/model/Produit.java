package com.adrar.evalspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;

@Entity
@Table(name="produit")
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le nom du produit ne peut pas être nul")
    @NotBlank(message = "Le nom du produit ne peut pas être vide")
    @Size(min = 3, message = "Le nom du produit doit contenir au moins 3 caractères")
    @Column(nullable = false, length = 50)
    private String name;

    @NotNull(message = "Le prix ne peut pas être nul")
    @Positive(message = "Le prix doit être supérieur à zéro")
    @Column(nullable = false)
    private Double price;
}
