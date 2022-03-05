package com.ynov.logicieladaptatif.client.model;

import com.ynov.logicieladaptatif.resolver.model.Ignore;
import com.ynov.logicieladaptatif.resolver.model.Model;
import com.ynov.logicieladaptatif.resolver.model.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Model
@Getter
@Setter
@NoArgsConstructor
@Document(collection = Client.COLLECTION)
public class Client {
    @Ignore
    public static final String COLLECTION = "client";

    @Id
    private String id;
    @NotNull(message = "nom should not be null")
    @NotBlank(message = "nom should not be a blank String")
    private String firstName;
    @NotNull(message = "prenom should not be null")
    @NotBlank(message = "prenom should not be a blank String")
    private String lastName;
    @NotNull(message = "mail should not be null")
    @NotBlank(message = "mail should not be a blank String")
    private String mail;
    @CreatedDate
    private Date createdAt;
    @Type(value = "list", model = Order.class)
    private List<Order> orders = new ArrayList<>();

    public Client(String firstName, String lastName, String mail, Date createdAt, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.createdAt = createdAt;
        this.orders = orders;
    }
}
