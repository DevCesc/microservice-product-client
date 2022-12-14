package com.bootcamp.service.impl;

import com.bootcamp.model.ProductClient;
import com.bootcamp.repository.IProductClientRepository;
import com.bootcamp.service.IProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ProductClientServiceImpl implements IProductClientService {

    @Autowired
    private IProductClientRepository repository;

    @Override
    public Flux<ProductClient> findAll() {
        return null;
    }

    @Override
    public Mono<ProductClient> findById(String id) {
        return null;
    }

    @Override
    public Flux<ProductClient> findAllByIdClient(String idClient) {
        return repository.findAllByIdClient(idClient);
    }

    @Override
    public Mono<ProductClient> save(ProductClient productClient) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        productClient.setDateCreated(simpleDateFormat.format(date));
        return repository.save(productClient);
    }

    @Override
    public Mono<ProductClient> update(ProductClient productClient) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
