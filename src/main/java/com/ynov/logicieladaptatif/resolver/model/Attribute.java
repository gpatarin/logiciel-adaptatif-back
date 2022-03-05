package com.ynov.logicieladaptatif.resolver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Attribute {
    private String name;
    private String type;
    @JsonInclude(Include.NON_NULL)
    private Resolver model = null;

    public Attribute(String name, String type) {
        this.name = name;
        this.type = type;
        this.model = null;
    }

    public Attribute(String name, String type, Resolver model) {
        this.name = name;
        this.type = type;
        this.model = model;
    }

}
