package com.ynov.logicieladaptatif.client.service;

import com.ynov.logicieladaptatif.client.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<Client> insertAll(Flux<Client> clients);
    Flux<Client> findAll();
    Mono<Client> findById(String id);
    Mono<Client> save(Client client);
    Mono<Void> deleteById(String id);
}
