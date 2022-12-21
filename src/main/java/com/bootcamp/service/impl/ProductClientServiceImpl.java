package com.bootcamp.service.impl;

import com.bootcamp.cacheconfig.CacheConfig;
import com.bootcamp.dto.ProductClientDto;
import com.bootcamp.model.ProductClient;
import com.bootcamp.repository.IProductClientRepository;
import com.bootcamp.service.IProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProductClientServiceImpl implements IProductClientService {

    @Autowired
    private IProductClientRepository repository;

    @Cacheable(value = "productClientCache", key = "#idClient")
    @Override
    public Flux<ProductClient> findAllByIdClient(String idClient) {
        return repository.findAllByIdClient(idClient);
    }

    @Override
    public Flux<ProductClient> findAllByIdClientAndDateRange(ProductClientDto productClientDto) {
        return repository.findAllByDateCreatedBetweenAndIdClient(productClientDto.getStartDate(),
                                                productClientDto.getEndDate(), productClientDto.getIdClient());
    }

    @Override
    public Mono<ProductClient> save(ProductClient productClient) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        productClient.setDateCreated(simpleDateFormat.format(date));
        return repository.save(productClient);
    }
}
