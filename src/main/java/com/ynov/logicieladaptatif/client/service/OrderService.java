package com.ynov.logicieladaptatif.client.service;

import com.ynov.logicieladaptatif.client.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Flux<Order> insertAll(String id, Flux<Order> orders);
    Flux<Order> findAll(String id);
    Mono<Order> findByIndex(String id, int index);
    Mono<Order> save(String id, int index, Order order);
}
