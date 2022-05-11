package com.ynov.logicieladaptatif.product.model;

import com.ynov.logicieladaptatif.resolver.model.Ignore;
import com.ynov.logicieladaptatif.resolver.model.Model;
import com.ynov.logicieladaptatif.resolver.model.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Model
@Getter
@Setter
@NoArgsConstructor
@Document(collection = Product.COLLECTION)
public class Product {
    @Ignore
    public static final String COLLECTION = "produit";

    @Id
    private String id;
    @NotNull(message = "name should not be null")
    @NotBlank(message = "name should not be a blank String")
    private String name;
    private int stock;
    @Type("image")
    @Null
    private String image;
    private double price;
}
