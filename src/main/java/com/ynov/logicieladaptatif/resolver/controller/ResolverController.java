package com.ynov.logicieladaptatif.resolver.controller;

import com.ynov.logicieladaptatif.resolver.model.Model;
import com.ynov.logicieladaptatif.resolver.model.Resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/resolver")
public class ResolverController {
    private final ApplicationContext context;
    private Set<BeanDefinition> modelsBeans;

    @Autowired
    public ResolverController(ApplicationContext context) {
        this.context = context;
        ClassPathScanningCandidateComponentProvider provider = createComponentScanner();
        modelsBeans = new HashSet<>();
        String packageName = getPackageName();

        if(packageName != null) {
            modelsBeans = provider.findCandidateComponents(packageName);
        }
    }

    private ClassPathScanningCandidateComponentProvider createComponentScanner() {
        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Model.class));
        return provider;
    }

    @GetMapping
    public Map<String, Resolver> resolve() throws ClassNotFoundException {
        Map<String, Resolver> elements = new HashMap<>();

        for(BeanDefinition modelBean: modelsBeans) {
            Class<?> c = Class.forName(modelBean.getBeanClassName());
            elements.put(c.getSimpleName(), new Resolver(c.getSimpleName().toLowerCase(Locale.ROOT), c.getDeclaredFields()));
        }
        return elements;
    }

    private String getPackageName() {
        Map<String, Object> springbootApplications = context.getBeansWithAnnotation(SpringBootApplication.class);
        if(!springbootApplications.isEmpty()) {
            String firstKey = springbootApplications.keySet().stream().findFirst().get();
            return springbootApplications.get(firstKey).getClass().getPackage().getName();
        }
        return null;
    }
}
