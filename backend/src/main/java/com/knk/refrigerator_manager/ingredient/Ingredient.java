package com.knk.refrigerator_manager.ingredient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.knk.refrigerator_manager.ingre_recipe.Ingre_recipe;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="ingredient")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Ingredient {
    @Id
    @Column(name = "ingre_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingreID;

    @Column(name = "ingre_name")
    private String ingreName;

    @Column(name = "img_source")
    private String imgSource;

    @Column(name = "default_ingre")
    private Boolean defaultIngre;

    //재료입장에서는 재료가 들어가있는 냉장고를 알아야 하나? => 없을듯
    //@JsonIgnore
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Ingre_recipe> ingre_recipes = new ArrayList<>();
}