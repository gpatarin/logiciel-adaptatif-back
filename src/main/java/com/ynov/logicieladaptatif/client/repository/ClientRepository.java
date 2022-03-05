package com.ynov.logicieladaptatif.client.repository;

import com.ynov.logicieladaptatif.client.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}
