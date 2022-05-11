package com.ynov.logicieladaptatif.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ynov.logicieladaptatif.resolver.model.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Date createdAt;
    private boolean isPaid = false;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date paidAt;
    private double price;
    private String[] products;
}
