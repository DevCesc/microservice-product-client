package com.bootcamp.controller;

import com.bootcamp.dto.ProductClientDto;
import com.bootcamp.model.ProductClient;
import com.bootcamp.service.IProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class ProductClientController {

    @Autowired
    private IProductClientService service;


    @PostMapping
    public Mono<ResponseEntity<ProductClient>> save(@RequestBody ProductClient productClient, final ServerHttpRequest req){
        return service.save(productClient)
                .map(e -> ResponseEntity
                        .created(URI.create(req.getURI().toString().concat("/").concat(e.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                );
    }

//    @Cacheable(value = "productClientCache", key = "#idClient")
    @GetMapping(value = "/{idclient}")
    public Mono<ResponseEntity<Flux<ProductClient>>> findAllByIdClient (@PathVariable("idclient") String idClient){
        Flux<ProductClient> fx = service.findAllByIdClient(idClient);
               return Mono.just(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fx)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/findAllByIdClientAndDateRange")
    public Mono<ResponseEntity<Flux<ProductClient>>> findAllByIdClientAndDateRange(@RequestBody ProductClientDto productClientDto) {
        Flux<ProductClient> fx = service.findAllByIdClientAndDateRange(productClientDto);
        return Mono.just(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fx)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
