package com.bootcamp.service;

import com.bootcamp.dto.ProductClientDto;
import com.bootcamp.model.ProductClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductClientService {

    Flux<ProductClient> findAllByIdClient(String id);
    Flux<ProductClient> findAllByIdClientAndDateRange(ProductClientDto productClientDto);
    Mono<ProductClient> save(ProductClient productClient);
}
