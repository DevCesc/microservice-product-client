package com.bootcamp.service;

import com.bootcamp.model.ProductClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductClientService {
    Flux<ProductClient> findAll();
    Mono<ProductClient> findById(String id);

    Flux<ProductClient> findAllByIdClient(String id);
    Mono<ProductClient> save(ProductClient productClient);
    Mono<ProductClient> update(ProductClient productClient);
    Mono<Void> delete(String id);
}
