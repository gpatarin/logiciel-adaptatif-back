package com.ynov.logicieladaptatif.resolver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
public class Resolver {
    private String name;
    private ArrayList<Attribute> attributes;

    public Resolver(String name, Field[] fields) {
        this.name = name;
        this.attributes = new ArrayList<>();
        for(Field f: fields) {
            Ignore ignore = f.getAnnotation(Ignore.class);
            Type customType = f.getAnnotation(Type.class);

            if(ignore == null) {
                String attrName = f.getName();
                String type = f.getType().getSimpleName().toLowerCase(Locale.ROOT);
                if(customType != null) {
                    type = customType.value();
                    if(customType.model() != Object.class) {
                        String className = customType.model().getSimpleName().toLowerCase(Locale.ROOT);
                        Field[] customTypeFields = customType.model().getDeclaredFields();
                        this.attributes.add(new Attribute(attrName, type, new Resolver(className, customTypeFields)));
                        return;
                    }
                }
                this.attributes.add(new Attribute(attrName, type));
            }
        }
    }
}
