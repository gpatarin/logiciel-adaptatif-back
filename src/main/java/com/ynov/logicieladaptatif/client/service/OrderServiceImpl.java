package com.ynov.logicieladaptatif.client.service;

import com.ynov.logicieladaptatif.client.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {

    private final ClientService clientService;

    @Autowired
    public OrderServiceImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Flux<Order> insertAll(String id, Flux<Order> orders) {
        return clientService.findById(id)
            .flatMapMany(client ->
                orders.collectList().flatMapMany(orderList -> {
                    client.getOrders().addAll(orderList);
                    return clientService.save(client)
                            .flatMapMany(savedClient -> Flux.fromIterable(savedClient.getOrders()));
                })
            );
    }

    @Override
    public Flux<Order> findAll(String id) {
        return clientService.findById(id)
                .flatMapMany(client -> Flux.fromIterable(client.getOrders()));
    }

    @Override
    public Mono<Order> findByIndex(String id, int index) {
        return clientService.findById(id)
                .flatMap(client -> Mono.just(client.getOrders().get(index)));
    }

    @Override
    public Mono<Order> save(String id, int index, Order order) {
        return clientService.findById(id)
                .flatMap(client -> {
                    client.getOrders().set(index, order);
                    return clientService.save(client)
                            .flatMap(savedClient -> Mono.just(savedClient.getOrders().get(index)));
                });
    }
}
