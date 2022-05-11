package com.ynov.logicieladaptatif.product.controller;

import com.ynov.logicieladaptatif.client.model.Client;
import com.ynov.logicieladaptatif.product.model.Product;
import com.ynov.logicieladaptatif.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping
    public Flux<Product> createProducts(@Valid @RequestBody Flux<Product> products) {
        return productService.insertAll(products);
    }

    @GetMapping
    public Flux<Product> readProducts() { return productService.findAll(); }

    @GetMapping("/{id}")
    public Mono<Product> readProduct(@RequestParam String id) { return productService.findById(id); }

    @PostMapping
    public Mono<Product> updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@RequestParam String id) {
        return productService.deleteById(id);
    }


}
