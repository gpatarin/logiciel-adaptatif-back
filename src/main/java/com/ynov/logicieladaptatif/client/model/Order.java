package com.ynov.logicieladaptatif.client.model;

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
    private Boolean isPaid = false;
    private Date paidAt;
    private int price;
    private String[] products;
}
