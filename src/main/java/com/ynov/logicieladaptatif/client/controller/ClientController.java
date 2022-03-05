package com.ynov.logicieladaptatif.client.controller;

import com.ynov.logicieladaptatif.client.model.Client;
import com.ynov.logicieladaptatif.client.model.Order;
import com.ynov.logicieladaptatif.client.service.ClientService;
import com.ynov.logicieladaptatif.client.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;
    private final OrderService orderService;

    @Autowired
    public ClientController(ClientService clientService, OrderService orderService) {
        this.clientService = clientService;
        this.orderService = orderService;
    }

    @PutMapping
    public Flux<Client> createClients(@Valid @RequestBody Flux<Client> clients) {
        return clientService.insertAll(clients);
    }

    @GetMapping
    public Flux<Client> readClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Client> readClient(@RequestParam String id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Mono<Client> updateClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}/order")
    public Flux<Order> createOrders(@RequestParam String id, @RequestBody Flux<Order> orders) {
        return orderService.insertAll(id, orders);
    }

    @GetMapping("/{id}/order")
    public Flux<Order> readOrders(@RequestParam String id) {
        return orderService.findAll(id);
    }

    @GetMapping("/{id}/order/{index}")
    public Mono<Order> readOrder(@RequestParam String id, @RequestParam int index) {
        return orderService.findByIndex(id, index);
    }

    @PostMapping("/{id}/order/{index}")
    public Mono<Order> updateOrder(@RequestParam String id, @RequestParam int index, @RequestBody Order order) {
        return orderService.save(id, index, order);
    }
}
