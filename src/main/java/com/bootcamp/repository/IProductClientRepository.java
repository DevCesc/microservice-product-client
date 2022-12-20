package com.bootcamp.repository;

import com.bootcamp.model.ProductClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IProductClientRepository extends ReactiveMongoRepository<ProductClient, String> {

    Flux<ProductClient> findAllByIdClient (String idClient);

    Flux<ProductClient> findAllByDateCreatedBetweenAndIdClient(String startDate, String endDate, String idClient);
}
